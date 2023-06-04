package Part1;

public class DoubleHashTable {
    private SpellSimple[] table;
    private final int capacity;
    private int size;
    private int steps = 0;

    public DoubleHashTable(int capacity) {
        this.capacity = capacity;
        this.table = new SpellSimple[capacity];
        this.size = 0;
        this.steps = 0;
    }

    public int getSize() {
        return this.size;
    }

    public int getLastSteps() {
        return this.steps;
    }

    public boolean put(SpellSimple spell) {
        if (size == capacity) {
            return false;
        }
        int tempSteps = 0;
        int hash = hash1(spell.getName());
        int curretntHash = hash;
        int step = hash2(spell.getName());
        int i = 0;
        if (table[curretntHash] == null) {
            table[curretntHash] = spell;
            this.steps = tempSteps;
            size++;
            return true;
        }
        while (table[curretntHash] != null) {
            i++;
            if (i == capacity) {
                break;
            }
            curretntHash = (hash + i * step) % capacity;
            tempSteps++;
            if (table[curretntHash] == null) {
                table[curretntHash] = spell;
                this.steps = tempSteps;
                size++;
                return true;
            }
        }
        return false;
    }

    public String getCastWords(String name) {
        int tempSteps = 0;
        int hash = hash1(name);
        int curretntHash = hash;
        int step = hash2(name);
        int i = 0;
        while (table[curretntHash] != null) {
            if (table[curretntHash].getName().equals(name)) {
                this.steps = tempSteps;
                return table[curretntHash].getWords();
            }
            i++;
            curretntHash = (hash + i * step) % capacity;
            tempSteps++;
            if (i == capacity - 1) {
                break;
            }
        }
        System.out.println("Spell not found"); //debugging purposes
        return null;
    }

    public int hash1(String name){
        int hash = 0;
        for (char c : name.toCharArray()){
            hash += c * 31;
        }
        return hash % capacity;
    }

    public int hash2(String name){
        int hash = 0;
        for (char c : name.toCharArray()){
            hash += c * 13;
        }
        return 1 + hash % (capacity - 2);
    }
}

package Part2;
import java.util.LinkedList;
import java.util.List;

public class HashAVLSpellTable {
    private LinkedList<AVLTree>[] buckets;
    private int tableSize;
    private int numSpells;

    public HashAVLSpellTable(int size) {
        this.tableSize = size;
        this.buckets = new LinkedList[size];
        this.numSpells = 0;
    }

    private int hash(String category) {
        int hash = 0;
        for (char c : category.toCharArray()) {
            hash += c;
        }
        return hash % tableSize;
    }

    public void addSpell(Spell s) {
        int index = hash(s.getCategory());
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        int size = buckets[index].size();
        int counter = 0; // counter for the for loop - helps with logic to check if the category already exists in the table.
        // if the category already exists in the table, add the spell to the tree in that category, if not, create a new tree for the new category.
        if (size != 0) {
            for (AVLTree tree : buckets[index]) {
                if (tree.getCategory().equals(s.getCategory())) {
                    tree.insert(s);
                    numSpells++;
                    break;
                } else if (counter == size - 1) {
                    buckets[index].add(new AVLTree(s));
                    numSpells++;
                    break;
                }
                counter++;
            }
        } else { // if the category is empty, create a new tree for that category and add the spell to it.
            buckets[index].add(new AVLTree(s));
            numSpells++;
        }
    }

    public Spell searchSpell(String category, String spellName, int powerLevel) {
        int index = hash(category);
        if (buckets[index] == null) {
            return null;
        }
        for (AVLTree tree : buckets[index]) {
            if (tree.getCategory().equals(category)) {
                return tree.search(spellName, powerLevel);
            }
        }
        return null;
    }

    public int getNumberSpells(){
        return numSpells;
    }

    public int getNumberSpells(String category){
        int index = hash(category);
        if (buckets[index] == null) {
            return 0;
        }
        for (AVLTree tree : buckets[index]) {
            if (tree.getCategory().equals(category)) {
                return tree.getSize();
            }
        }
        return 0;
    }

    public List<Spell> getTopK(String category, int k) {
        int index = hash(category);
        if (buckets[index] == null) {
            return null;
        }
        for (AVLTree tree : buckets[index]) {
            if (tree.getCategory().equals(category)) {
                return tree.getTopK(k);
            }
        }
        return null;
    }
}


package Part2;
import java.util.LinkedList;
import java.util.List;

public class HashAVLSpellTable {
    private LinkedList<AVLTree> buckets[];
    private int tableSize;
    private int numSpells;

    public HashAVLSpellTable(int size) {

    }

    private int hash(String category) {
        int hash = 0;
        for (char c : category.toCharArray()) {
            hash += c;
        }
        return hash % tableSize;
    }

    public void addSpell(Spell s) {
    }

    public Spell searchSpell(String category, String spellName, int powerLevel) {
        return null;
    }

    public int getNumberSpells(){
        return 0;
    }

    public int getNumberSpells(String category){
        return 0;
    }

    public List<Spell> getTopK(String category, int k) {
        return null;
    }
}


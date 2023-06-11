package Part2;

// 207194879
// 206001018
public class Spell {
    private String name;
    private String category;
    private int powerLevel;
    private String words;
    public Spell(String name, String category, int powerLevel, String words){
        if (name == null || category == null || words == null) {
            throw new IllegalArgumentException("Part2.Spell name, category, and words cannot be null.");
        }
        this.name = name;
        this.category = category;
        this.powerLevel = powerLevel;
        this.words = words;
    }

    public String getName() {
        return this.name;
    }

    public String getCategory() {
        return this.category;
    }

    public int getPowerLevel() {
        return this.powerLevel;
    }

    public String getWords() {
        return this.words;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - Power Level: " + powerLevel + ", to cast say: " + words;
    }
}

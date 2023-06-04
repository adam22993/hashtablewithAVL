package Part1;

public class SpellSimple {
    private final String name;
    private final String words;

    public SpellSimple(String name, String words){
        this.name = name;
        this.words = words;
    }
    public String getWords(){
        return words;
    }
    public String getName (){
        return name;
    }
}

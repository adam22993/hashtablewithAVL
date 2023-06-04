import Part1.*;
import Part2.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DoubleHashTable table = new DoubleHashTable(10);

        // Add some spells to the table
        table.put(new SpellSimple("Abracadabra", "Avada Kedavra"));
        table.put(new SpellSimple("Expecto Patronum", "I’m gonna stand here like a unicorn"));
        table.put(new SpellSimple("Wingardium Leviosa", "Get up, stand up"));
        table.put(new SpellSimple("Shazam", "24K Magic in the air"));

        // Get the spells by name
        System.out.println(table.getCastWords("Shazam")); // prints "24K Magic in the air"
        System.out.println(table.getCastWords("Abracadabra")); // prints "Avada Kedavra"

        // Get the size of the table
        int size = table.getSize();
        System.out.println("Table size: " + size); // prints "Table size: 4"




        // create a new hash AVL spell table
        HashAVLSpellTable table3 = new HashAVLSpellTable(10);

        // create some spells
        Spell spell1 = new Spell("fireball", "fire", 10, "fireball!");
        Spell spell2 = new Spell("frostbolt", "ice", 7, "freeze please");
        Spell spell3 = new Spell("thunderstorm", "lightning", 9, "I`m going to shock you");
        Spell spell4 = new Spell("poison spray", "poison", 5, "sssss");
        Spell spell5 = new Spell("shockwave", "lightning", 8, "go pikachu!");

        // add the spells to the hash AVL spell table
        table3.addSpell(new Spell("lightning bolt", "lightning", 11, "go lightning bolt"));
        table3.addSpell(spell1);
        table3.addSpell(spell2);
        table3.addSpell(spell3);
        table3.addSpell(spell4);
        table3.addSpell(spell5);

        // add more spells to an existing category
        table3.addSpell(new Spell("flamethrower min", "fire", 6, "foo"));
        table3.addSpell(new Spell("flamethrower", "fire", 8, "foo better"));
        table3.addSpell(new Spell("fireball II", "fire", 12,"fireball!!"));
        table3.addSpell(new Spell("flamethrower II", "fire", 15, "foooooooo!"));
        table3.addSpell(new Spell("shockwave II", "lightning", 10,"be useful pikachu."));
        table3.addSpell(new Spell("frost nova", "ice", 4, "chill dude"));

        System.out.println("The current number of spells is " + table3.getNumberSpells()); // prints the total number of spells
        System.out.println("The current number of fire spells spells is " + table3.getNumberSpells("fire")); // prints the total number of fire spells

        // get the top 3 spells in the "fire" category
        System.out.println("Top 3 spells in the 'fire' category:");
        List<Spell> fireSpells = table3.getTopK("fire", 3);
        for (Spell s : fireSpells) {
            System.out.println(s.toString()); // prints the top 3 spells in fire category in descending order
        }

        // get the top 3 spells in the "lightning" category
        System.out.println("Top 3 spells in the 'lightning' category:");
        List<Spell> lightningSpells = table3.getTopK("lightning", 3);
        for (Spell s : lightningSpells) {
            System.out.println(s.toString()); // prints the top 3 spells in lightning category in descending order
        }

        // spell that exists in the table
        Spell searchedSpell = table3.searchSpell("fire","fireball",  10);
        if (searchedSpell != null) {
            System.out.println("Spell Found: " + searchedSpell.toString());
        } else {
            System.out.println("Spell Not Found");
        }

        // search for a spell that does not exist in the table
        searchedSpell = table3.searchSpell("fire", "fireball", 11);
        if (searchedSpell != null) {
            System.out.println("Spell Found: " + searchedSpell.toString());
        } else {
            System.out.println("Spell Not Found");
        }

        // search for a spell that does not exist in the table
        searchedSpell = table3.searchSpell("ice", "fireball", 10);
        if (searchedSpell != null) {
            System.out.println("Spell Found: " + searchedSpell.toString());
        } else {
            System.out.println("Spell Not Found");
        }
    }
}

package Part2;// 207194879
// 206001018
import Part2.AVLTree;
import Part2.HashAVLSpellTable;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
public class MainPart2 {
    @Test
    public void testAVLTree() {
        Spell spell1 = new Spell("fireball", "fire", 11, "fireball! classic (TM)!");
        AVLTree tree = new AVLTree(spell1);
        Spell spell2 = new Spell("megafireball", "fire", 5, "MEGA FIREBALL!");
        Spell spell3 = new Spell("fireblablaball", "fire", 4, "yeah yeah yeah...");
        tree.insert(spell2);
        tree.insert(spell3);
        Spell spell4 = new Spell("firedestructionball", "fire", 15, "I think megadeath wrote a song about this one...");
        tree.insert(spell4);
        Spell spell5 = new Spell("firedeathball", "fire", 20, "you ain't dealing with this one...");
        tree.insert(spell5);
        Spell spell6 = new Spell("supermegafireball", "fire", 12, "A colossal fireball!... da...");
        tree.insert(spell6);
        Spell spell7 = new Spell("lavabunnies", "fire", 9, "these bunnies are on fire!!");
        tree.insert(spell7);
        Spell spell8 = new Spell("Mad girlfriend", "fire", 7, "She ain't mad... she's is furious! foaming at the mouth kind of mad!");
        tree.insert(spell8);
        Spell spell9 = new Spell("Check thermostat", "fire", 8, "It's getting hot in here, so take off all your clothes!");
        tree.insert(spell9);
        Spell spell10 = new Spell("Lit girl", "fire", 10, "This girl is on fire! She's walking on fire! She's fire!");
        tree.insert(spell10);

        // after all 10 insertions, the getTopK(10) and any k higher than 10 should return the following:
        assertEquals("[firedeathball (fire) - Power Level: 20, to cast say: you ain't dealing with this one..., firedestructionball (fire) - Power Level: 15, to cast say: I think megadeath wrote a song about this one..., supermegafireball (fire) - Power Level: 12, to cast say: A colossal fireball!... da..., fireball (fire) - Power Level: 11, to cast say: fireball! classic (TM)!, Lit girl (fire) - Power Level: 10, to cast say: This girl is on fire! She's walking on fire! She's fire!, lavabunnies (fire) - Power Level: 9, to cast say: these bunnies are on fire!!, Check thermostat (fire) - Power Level: 8, to cast say: It's getting hot in here, so take off all your clothes!, Mad girlfriend (fire) - Power Level: 7, to cast say: She ain't mad... she's is furious! foaming at the mouth kind of mad!, megafireball (fire) - Power Level: 5, to cast say: MEGA FIREBALL!, fireblablaball (fire) - Power Level: 4, to cast say: yeah yeah yeah...]", tree.getTopK(10).toString());

        // after all 10 insertions, the getTopK(100) should return the same message as above:
        assertEquals("[firedeathball (fire) - Power Level: 20, to cast say: you ain't dealing with this one..., firedestructionball (fire) - Power Level: 15, to cast say: I think megadeath wrote a song about this one..., supermegafireball (fire) - Power Level: 12, to cast say: A colossal fireball!... da..., fireball (fire) - Power Level: 11, to cast say: fireball! classic (TM)!, Lit girl (fire) - Power Level: 10, to cast say: This girl is on fire! She's walking on fire! She's fire!, lavabunnies (fire) - Power Level: 9, to cast say: these bunnies are on fire!!, Check thermostat (fire) - Power Level: 8, to cast say: It's getting hot in here, so take off all your clothes!, Mad girlfriend (fire) - Power Level: 7, to cast say: She ain't mad... she's is furious! foaming at the mouth kind of mad!, megafireball (fire) - Power Level: 5, to cast say: MEGA FIREBALL!, fireblablaball (fire) - Power Level: 4, to cast say: yeah yeah yeah...]", tree.getTopK(100).toString());

        // after all 10 insertions, the search("fireball", 20) should return the following:
        assertEquals("fireball (fire) - Power Level: 11, to cast say: fireball! classic (TM)!", tree.search("fireball", 11).toString());

        // after all 10 insertions, the search("firedestructionball", 15) should return the following:
        assertEquals("firedestructionball (fire) - Power Level: 15, to cast say: I think megadeath wrote a song about this one...", tree.search("firedestructionball", 15).toString());
        assertEquals(3, tree.getTreeHeight());

        // create a tree with any number - positive or negative or 0 - of spells, should be ok:
        Spell spell11 = new Spell("fireball", "fire", -5, "fireball! classic (TM)!");
        Spell spell12 = new Spell("megafireball", "fire", -10, "MEGA FIREBALL!");
        Spell spell13 = new Spell("fireblablaball", "fire", 0, "yeah yeah yeah...");
        Spell spell14 = new Spell("firedestructionball", "fire", 15, "I think megadeath wrote a song about this one...");
        AVLTree anySpellTree = new AVLTree(spell11);
        anySpellTree.insert(spell12);
        anySpellTree.insert(spell13);
        anySpellTree.insert(spell14);

        // after all 4 insertions, the getTopK(4) should return the following:
        assertEquals("[firedestructionball (fire) - Power Level: 15, to cast say: I think megadeath wrote a song about this one..., fireblablaball (fire) - Power Level: 0, to cast say: yeah yeah yeah..., fireball (fire) - Power Level: -5, to cast say: fireball! classic (TM)!, megafireball (fire) - Power Level: -10, to cast say: MEGA FIREBALL!]", anySpellTree.getTopK(4).toString());
        // test for higher k than the number of spells in the tree:
        assertEquals("[firedestructionball (fire) - Power Level: 15, to cast say: I think megadeath wrote a song about this one..., fireblablaball (fire) - Power Level: 0, to cast say: yeah yeah yeah..., fireball (fire) - Power Level: -5, to cast say: fireball! classic (TM)!, megafireball (fire) - Power Level: -10, to cast say: MEGA FIREBALL!]", anySpellTree.getTopK(100).toString());
        // test for k = 0:
        assertEquals("[]", anySpellTree.getTopK(0).toString());
        // test for k = 1:
        assertEquals("[firedestructionball (fire) - Power Level: 15, to cast say: I think megadeath wrote a song about this one...]", anySpellTree.getTopK(1).toString());

        // height should be 2:
        assertEquals(2, anySpellTree.getTreeHeight());

    }
    @Test
    public void testHashAVLSpellTable(){
        // creating a table with size 0 or less should throw an exception:
        assertThrows(IllegalArgumentException.class, () -> {
            HashAVLSpellTable table12 = new HashAVLSpellTable(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            HashAVLSpellTable table12 = new HashAVLSpellTable(-1);
        });
        // creating a table with size 1 or higher should not throw an exception:
        HashAVLSpellTable table = new HashAVLSpellTable(1);
        HashAVLSpellTable table2 = new HashAVLSpellTable(2);
        HashAVLSpellTable testingTable = new HashAVLSpellTable(6);

        // inserting a spell with a null key should throw an exception:
        assertThrows(IllegalArgumentException.class, () -> {
            testingTable.addSpell(null);
        });

        //adding a couple of spells to testingTable
        Spell spell1 = new Spell("fireball", "fire", 11, "fireball! classic (TM)!");
        Spell spell2 = new Spell("megafireball", "fire", 5, "MEGA FIREBALL!");
        Spell spell3 = new Spell("fireblablaball", "fire", 4, "yeah yeah yeah...");
        Spell spell4 = new Spell("firedestructionball", "fire", 15, "I think megadeath wrote a song about this one...");
        Spell spell5 = new Spell("lightningStrick", "lightning", 10, "ZAP!");
        Spell spell6 = new Spell("lightningBolt", "lightning", 5, "ZAP!");
        Spell spell7 = new Spell("Frozen", "ice", 10, "Let it go!");
        Spell spell8 = new Spell("Frozen2", "ice", 5, "Let it go! Again!");
        Spell spell9 = new Spell("Frozen3", "ice", 15, "Let it go! Again! Again!");
        Spell spell10 = new Spell("Frozen4", "ice", 20, "Let it go! Again! Again! Again!");
        Spell spell11 = new Spell("river", "water", 10, "Water is life!");
        Spell spell12 = new Spell("ocean", "water", 5, "Water is life! but bigger!");
        Spell spell13 = new Spell("sea", "water", 15, "Water is life! but bigger! and salty!");
        Spell spell14 = new Spell("PACIFIC OCEAN", "water", 20, "Water is life! but bigger! and salty! and deep!");
        Spell spell15 = new Spell("PACIFIC OCEAN", "firef", 20, "Water is life! but bigger! and salty! and deep!");

        // adding the spells to the testingTable
        testingTable.addSpell(spell1);
        testingTable.addSpell(spell2);
        testingTable.addSpell(spell3);
        testingTable.addSpell(spell4);
        testingTable.addSpell(spell5);
        testingTable.addSpell(spell6);
        testingTable.addSpell(spell7);
        testingTable.addSpell(spell8);
        testingTable.addSpell(spell9);
        testingTable.addSpell(spell10);
        testingTable.addSpell(spell11);
        testingTable.addSpell(spell12);
        testingTable.addSpell(spell13);
        testingTable.addSpell(spell14);
        testingTable.addSpell(spell15); // suppose to be added to bucket number 2 with a new tree

        System.out.println(testingTable.toString());
        assertEquals("Bucket index 1, tree index 0:  ocean (water) - Power Level: 5, to cast say: Water is life! but bigger!  river (water) - Power Level: 10, to cast say: Water is life!  sea (water) - Power Level: 15, to cast say: Water is life! but bigger! and salty!  PACIFIC OCEAN (water) - Power Level: 20, to cast say: Water is life! but bigger! and salty! and deep! \n" +
                "Bucket index 2, tree index 0:  fireblablaball (fire) - Power Level: 4, to cast say: yeah yeah yeah...  megafireball (fire) - Power Level: 5, to cast say: MEGA FIREBALL!  fireball (fire) - Power Level: 11, to cast say: fireball! classic (TM)!  firedestructionball (fire) - Power Level: 15, to cast say: I think megadeath wrote a song about this one... \n" +
                "Bucket index 2, tree index 1:  PACIFIC OCEAN (firef) - Power Level: 20, to cast say: Water is life! but bigger! and salty! and deep! \n" +
                "Bucket index 4, tree index 0:  lightningBolt (lightning) - Power Level: 5, to cast say: ZAP!  lightningStrick (lightning) - Power Level: 10, to cast say: ZAP! \n" +
                "Bucket index 5, tree index 0:  Frozen2 (ice) - Power Level: 5, to cast say: Let it go! Again!  Frozen (ice) - Power Level: 10, to cast say: Let it go!  Frozen3 (ice) - Power Level: 15, to cast say: Let it go! Again! Again!  Frozen4 (ice) - Power Level: 20, to cast say: Let it go! Again! Again! Again! \n", testingTable.toString());
    }

    @Test
    public void testSpell(){
        // creating a spell with a null key should throw an exception:
        assertThrows(IllegalArgumentException.class, () -> {
            Spell spell = new Spell(null, "fire", 11, "fireball! classic (TM)!");
        });
        // creating a spell with a null type should throw an exception:
        assertThrows(IllegalArgumentException.class, () -> {
            Spell spell = new Spell("fireball", null, 11, "fireball! classic (TM)!");
        });
        // creating a spell with a null description should throw an exception:
        assertThrows(IllegalArgumentException.class, () -> {
            Spell spell = new Spell("fireball", "fire", 11, null);
        });

        // creating a spell with any power level should not throw an exception:
        Spell spell = new Spell("fireball", "fire", 11, "fireball! classic (TM)!");
        Spell spell2 = new Spell("fireball", "fire", 1, "fireball! classic (TM)!");
        Spell spell3 = new Spell("fireball", "fire", 100, "fireball! classic (TM)!");
        Spell spell4 = new Spell("fireball", "fire", 1000, "fireball! classic (TM)!");
        Spell spell5 = new Spell("fireball", "fire", 10000, "fireball! classic (TM)!");
        Spell spell6 = new Spell("fireball", "fire", 100000, "fireball! classic (TM)!");
        Spell spell7 = new Spell("fireball", "fire", 1000000, "fireball! classic (TM)!");
        Spell spell8 = new Spell("fireball", "fire", 10000000, "fireball! classic (TM)!");
        Spell spell9 = new Spell("fireball", "fire", 100000000, "fireball! classic (TM)!");
        Spell spell10 = new Spell("fireball", "fire", -1, "fireball! classic (TM)!");
        Spell spell11 = new Spell("fireball", "fire", -100, "fireball! classic (TM)!");
        Spell spell12 = new Spell("fireball", "fire", 0, "fireball! classic (TM)!");

        // test the getters:
        Assert.assertEquals("fireball", spell.getName());
        Assert.assertEquals("fire", spell.getCategory());
        Assert.assertEquals(11, spell.getPowerLevel());
        Assert.assertEquals("fireball! classic (TM)!", spell.getWords());
    }
}

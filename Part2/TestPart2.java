package Part2;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestPart2 {
    @Test
    public void testAVLTree(){
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
        assertEquals("[firedeathball (fire) - Power Level: 20, to cast say: you ain't dealing with this one..., firedestructionball (fire) - Power Level: 15, to cast say: I think megadeath wrote a song about this one..., supermegafireball (fire) - Power Level: 12, to cast say: A colossal fireball!... da..., fireball (fire) - Power Level: 11, to cast say: fireball! classic (TM)!, Lit girl (fire) - Power Level: 10, to cast say: This girl is on fire! She's walking on fire! She's fire!, lavabunnies (fire) - Power Level: 9, to cast say: these bunnies are on fire!!, Check thermostat (fire) - Power Level: 8, to cast say: It's getting hot in here, so take off all your clothes!, Mad girlfriend (fire) - Power Level: 7, to cast say: She ain't mad... she's is furious! foaming at the mouth kind of mad!, megafireball (fire) - Power Level: 5, to cast say: MEGA FIREBALL!, fireblablaball (fire) - Power Level: 4, to cast say: yeah yeah yeah...]", tree.getTopK(100).toString());

        // after all 10 insertions, the search("fireball", 20) should return the following:
        assertEquals("fireball (fire) - Power Level: 11, to cast say: fireball! classic (TM)!", tree.search("fireball", 11).toString());

        // after all 10 insertions, the search("firedestructionball", 15) should return the following:
        assertEquals("firedestructionball (fire) - Power Level: 15, to cast say: I think megadeath wrote a song about this one...", tree.search("firedestructionball", 15).toString());
        assertEquals(3, tree.getTreeHeight());
    }
}

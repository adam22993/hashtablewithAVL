package Part1;// 207194879
// 206001018
import Part1.DoubleHashTable;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
public class MainPart1 {
    @Test
    public void testSpellSimple() {
        SpellSimple spell = new SpellSimple("Accio", "Summoning Charm");
        Assert.assertEquals("Accio", spell.getName());
        Assert.assertEquals("Summoning Charm", spell.getWords());
    }

    @Test
    public void testDoubleHashTable(){
        // Test 1 - Create a table and overflow it without losing any data & check the steps in the process
        DoubleHashTable table1 = new DoubleHashTable(3);
        assertEquals(0, table1.getSize());
        assertEquals(0, table1.getLastSteps());
        assertTrue(table1.put(new SpellSimple("Summoning Charm", "Accio")));
        assertEquals(1, table1.getSize());
        assertEquals(0, table1.getLastSteps());
        assertTrue(table1.put(new SpellSimple("Banishing Charm", "Depulso")));
        assertEquals(2, table1.getSize());
        assertEquals(1, table1.getLastSteps());
        assertTrue(table1.put(new SpellSimple("Destroying Charm", "Deletrius")));
        assertEquals(3, table1.getSize());
        assertEquals(0, table1.getLastSteps());


        // Test 2 - Retrieve data from the table and check the steps in the process
        assertEquals("Accio", table1.getCastWords("Summoning Charm"));
        assertEquals(0, table1.getLastSteps());
        assertEquals("Depulso", table1.getCastWords("Banishing Charm"));
        assertEquals(1, table1.getLastSteps());
        assertEquals("Deletrius", table1.getCastWords("Destroying Charm"));
        assertEquals(0, table1.getLastSteps());

        // Test 3 - Overflow table and expect false - with various steps to check
        assertFalse(table1.put(new SpellSimple("Pulling spell", "Get over here!")));
        assertEquals(3, table1.getSize());
        assertEquals(0, table1.getLastSteps());
        assertEquals("Depulso", table1.getCastWords("Banishing Charm"));
        assertEquals(1, table1.getLastSteps());
        assertFalse(table1.put(new SpellSimple("Pulling spell", "Get over here!"))); //checking again to see if the steps are not changed
        assertEquals(3, table1.getSize());
        assertEquals(1, table1.getLastSteps());
    }
    @Test
    public void testHashes(){
        DoubleHashTable table2 = new DoubleHashTable(6);
        // Test 1 - Check the hash1 function
        assertEquals(5, table2.hash1("A"));
        assertEquals(0, table2.hash1("B"));
        assertEquals(2, table2.hash1("D"));
        assertEquals(2, table2.hash1("P"));

        // Test 2 - Check the hash2 function
        assertEquals(2, table2.hash2("A"));
        assertEquals(3, table2.hash2("B"));
        assertEquals(1, table2.hash2("D"));
        assertEquals(1, table2.hash2("P"));

        // try and create an empty hash table with 2 buckets
        assertThrows(IllegalArgumentException.class, () -> new DoubleHashTable(0));
        assertThrows(IllegalArgumentException.class, () -> new DoubleHashTable(-1));
        assertThrows(IllegalArgumentException.class, () -> new DoubleHashTable(1));
        assertThrows(IllegalArgumentException.class, () -> new DoubleHashTable(2));


    }
}

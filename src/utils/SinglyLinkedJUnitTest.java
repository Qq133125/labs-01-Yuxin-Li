import utils.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedJUnitTest {
    private SinglyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList<>();
        System.out.println("\nA new test begins, the list has been initialized.");
    }

    @Test
    void testIsEmptyOnNewList() {
        System.out.println("Testing if a new list is empty");
        assertTrue(list.isEmpty());
    }

    @Test
    void testAddToEnd() {
        list.add(1);
        System.out.println("Adding an element to the end of the list: " + list.toString());
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
    }

    @Test
    void testAddAtIndex() {
        list.add(0, 1);
        list.add(1, 3);
        list.add(1, 2);
        System.out.println("Adding elements at specific indexes: " + list.toString());
        assertEquals(3, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        Integer removed = list.remove(1);
        System.out.println("Removing the element at index 1 (" + removed + "): " + list.toString());
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
    }

    @Test
    void testSet() {
        list.add(1);
        list.add(2);
        Integer old = list.set(1, 20);
        System.out.println("Changing the element at index 1 from " + old + " to 20: " + list.toString());
        assertEquals(Integer.valueOf(20), list.get(1));
    }

    @Test
    void testSize() {
        System.out.println("Testing the size of the list");
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
        list.add(2);
        assertEquals(2, list.size());
        System.out.println("Current list: " + list.toString() + " Size: " + list.size());
    }

    @Test
    void testToString() {
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Testing the toString method: " + list.toString());
        String expected = "1 -> 2 -> 3 -> null";
        assertEquals(expected, list.toString());
    }

    @Test
    void testCheckIndexOutOfBoundsException() {
        System.out.println("Testing for IndexOutOfBoundsException");
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0)); // When the list is empty
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1)); // Negative index
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1)); // Index greater than list size
    }
}

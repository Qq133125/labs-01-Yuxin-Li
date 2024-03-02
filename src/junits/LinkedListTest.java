
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

public class LinkedListTest {
    private LinkedList<String> list;

    @BeforeEach
    public void setup() {
        list = new LinkedList<>();
    }

    @Test
    public void testAdd() {
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println("After adding 3 elements: " + list);
    }

    @Test
    public void testAddAtIndex() {
        list.add("A");
        list.add("B");
        list.add(1, "C");

        System.out.println("After inserting 'C' at index 1: " + list);
    }

    @Test
    public void testRemove() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.remove(1);

        System.out.println("After removing element at index 1: " + list);
    }

    @Test
    public void testSet() {
        list.add("A");
        list.add("B");
        list.set(1, "C");

        System.out.println("After setting element at index 1 to 'C': " + list);
    }

    @Test
    public void testIndexOf() {
        list.add("A");
        list.add("B");
        list.add("C");
        int index = list.indexOf("B");

        System.out.println("'B' is found at index " + index);
    }

    @Test
    public void testGet() {
        list.add("A");
        list.add("B");
        String element = list.get(1);

        System.out.println("Element at index 1 is " + element);
    }

    @Test
    public void testSize() {
        list.add("A");
        list.add("B");
        int size = list.size();

        System.out.println("Size of the list is " + size);
    }
}

package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    
    @Test
    public void testAdd() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        assertEquals(10, addedIll.getRoot().getNext().getValue());
    }

    @Test
    public void testAddEmpty() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        assertEquals(10, addedIll.getRoot().getValue());
    }

    @Test
    public void testAddByIndex() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        ImmutableLinkedList addedByIndexIll = (ImmutableLinkedList) addedIll.add(1, -1);
        assertEquals(-1, addedByIndexIll.getRoot().getNext().getValue());
    }

    @Test
    public void testAddByZeroIndex() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        ImmutableLinkedList addedByIndexIll = (ImmutableLinkedList) addedIll.add(0, -1);
        assertEquals(-1, addedByIndexIll.getRoot().getValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexOutOfRange() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        ImmutableLinkedList addedByIndexIll = (ImmutableLinkedList) addedIll.add(10, -1);
        assertEquals(-1, addedByIndexIll.getRoot().getValue());
    }
}

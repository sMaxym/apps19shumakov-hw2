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
    
}

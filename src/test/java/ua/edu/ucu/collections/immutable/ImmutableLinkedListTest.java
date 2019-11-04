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

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexOutOfRange() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        ImmutableLinkedList addedByIndexIll = (ImmutableLinkedList) addedIll.add(10, -1);
        assertEquals(-1, addedByIndexIll.getRoot().getValue());
    }

    @Test
    public void testAddAll() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        Object[] c = {26, 27, 28, 29};
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.addAll(c);
        Node currentTarget = addedIll.getRoot();
        for (int i = 0; i < 3; i++) {
            currentTarget = currentTarget.getNext();
        }
        assertEquals(28, currentTarget.getValue());
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllNone() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        Object[] c = {};
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.addAll(c);
        Node currentTarget = addedIll.getRoot();
        assertEquals(null, currentTarget.getNext().getValue());
    }

    @Test
    public void testAddAllIndex() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ImmutableLinkedList addedIllNew = (ImmutableLinkedList) addedIll.addAll(1, c);
        Node currentTarget = addedIllNew.getRoot();
        for (int i = 0; i < 5; i++) {
            currentTarget = currentTarget.getNext();
        }
        assertEquals(10, currentTarget.getValue());
    }

    @Test
    public void testGet() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        assertEquals(25, ill.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfRange() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        assertEquals(1, ill.get(1230));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveOne() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList newll = (ImmutableLinkedList) ill.remove(0);
        assertEquals(null, newll.getRoot());
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ImmutableLinkedList addedIllNew = (ImmutableLinkedList) addedIll.addAll(1, c);
        ImmutableLinkedList newll = (ImmutableLinkedList) addedIllNew.remove(3);
        Node currentTarget = newll.getRoot();
        for (int i = 0; i < 3; i++) {
            currentTarget = currentTarget.getNext();
        }
        assertEquals(29, currentTarget.getValue());
    }

    @Test
    public void testSet() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ImmutableLinkedList addedIllNew = (ImmutableLinkedList) addedIll.addAll(1, c);
        ImmutableLinkedList newll = (ImmutableLinkedList) addedIllNew.set(3, 69);
        Node currentTarget = newll.getRoot();
        for (int i = 0; i < 3; i++) {
            currentTarget = currentTarget.getNext();
        }
        assertEquals(69, currentTarget.getValue());
    }

    @Test
    public void testIndexOf() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ImmutableLinkedList addedIllNew = (ImmutableLinkedList) addedIll.addAll(1, c);
        ImmutableLinkedList newll = (ImmutableLinkedList) addedIllNew.set(3, 69);
        assertEquals(3, newll.indexOf(69));
    }

    @Test
    public void testSize() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ImmutableLinkedList addedIllNew = (ImmutableLinkedList) addedIll.addAll(1, c);
        ImmutableLinkedList newll = (ImmutableLinkedList) addedIllNew.set(3, 69);
        assertEquals(6, newll.size());
    }

    @Test
    public void testClear() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ImmutableLinkedList addedIllNew = (ImmutableLinkedList) addedIll.addAll(1, c);
        ImmutableLinkedList newll = (ImmutableLinkedList) addedIllNew.clear();
        assertEquals(0, newll.size());
    }

    @Test
    public void testIsEmpty() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ImmutableLinkedList addedIllNew = (ImmutableLinkedList) addedIll.addAll(1, c);
        ImmutableLinkedList newll = (ImmutableLinkedList) addedIllNew.clear();
        assertEquals(true, newll.isEmpty());
    }

    @Test
    public void testToArray() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ImmutableLinkedList addedIllNew = (ImmutableLinkedList) addedIll.addAll(1, c);
        Object[] ar = {25, 26, 27, 28, 29, 10};
        assertArrayEquals(ar, addedIllNew.toArray());
    }

    @Test
    public void testToString() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ImmutableLinkedList addedIllNew = (ImmutableLinkedList) addedIll.addAll(1, c);
        assertEquals("25 26 27 28 29 10", addedIllNew.toString());
    }

    @Test
    public void TestAddFirst() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ImmutableLinkedList addedIllNew = (ImmutableLinkedList) addedIll.addAll(1, c);
        ImmutableLinkedList newList = (ImmutableLinkedList) addedIllNew.addFirst(1);
        assertEquals("1 25 26 27 28 29", newList.toString());
    }

    @Test
    public void TestAddLast() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        assertEquals(10, addedIll.getRoot().getNext().getValue());
    }

    @Test
    public void TestGetFirst() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        ImmutableLinkedList addedIllNew = (ImmutableLinkedList) addedIll.add(12);
        assertEquals(25, addedIll.getFirst());
    }

    @Test
    public void TestGetLast() {
        ImmutableLinkedList ill = new ImmutableLinkedList(25);
        ImmutableLinkedList addedIll = (ImmutableLinkedList) ill.add(10);
        ImmutableLinkedList addedIllNew = (ImmutableLinkedList) addedIll.add(12);
        assertEquals(12, addedIllNew.getLast());
    }
}
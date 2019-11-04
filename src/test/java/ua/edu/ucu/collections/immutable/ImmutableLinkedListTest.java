package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void testAdd() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        assertEquals(10, ill.getRoot().getNext().getValue());
    }

    @Test
    public void testAddEmpty() {
        ImmutableLinkedList ill = new ImmutableLinkedList();
        ill = (ImmutableLinkedList) ill.add(10);
        assertEquals(10, ill.getRoot().getValue());
    }

    @Test
    public void testAddByIndex() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        ill = (ImmutableLinkedList) ill.add(1, -1);
        assertEquals(-1, ill.getRoot().getNext().getValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexOutOfRange() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        ill = (ImmutableLinkedList) ill.add(10, -1);
        assertEquals(-1, ill.getRoot().getValue());
    }

    @Test
    public void testAddAll() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        Object[] c = {26, 27, 28, 29};
        ill = (ImmutableLinkedList) ill.addAll(c);
        Node currentTarget = ill.getRoot();
        for (int i = 0; i < 3; i++) {
            currentTarget = currentTarget.getNext();
        }
        assertEquals(28, currentTarget.getValue());
    }

    @Test(expected = NullPointerException.class)
    public void testAddAllNone() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        Object[] c = {};
        ill = (ImmutableLinkedList) ill.addAll(c);
        Node currentTarget = ill.getRoot();
        assertEquals(null, currentTarget.getNext().getValue());
    }

    @Test
    public void testAddAllIndex() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ill = (ImmutableLinkedList) ill.addAll(1, c);
        Node currentTarget = ill.getRoot();
        for (int i = 0; i < 5; i++) {
            currentTarget = currentTarget.getNext();
        }
        assertEquals(10, currentTarget.getValue());
    }

    @Test
    public void testGet() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        assertEquals(25, ill.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexOutOfRange() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        assertEquals(1, ill.get(1230));
    }

    @Test
    public void testRemoveOne() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.remove(0);
        assertEquals(null, ill.getRoot());
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ill = (ImmutableLinkedList) ill.addAll(1, c);
        ill = (ImmutableLinkedList) ill.remove(3);
        Node currentTarget = ill.getRoot();
        for (int i = 0; i < 3; i++) {
            currentTarget = currentTarget.getNext();
        }
        assertEquals(29, currentTarget.getValue());
    }

    @Test
    public void testSet() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ill = (ImmutableLinkedList) ill.addAll(1, c);
        ill = (ImmutableLinkedList) ill.set(3, 69);
        Node currentTarget = ill.getRoot();
        for (int i = 0; i < 3; i++) {
            currentTarget = currentTarget.getNext();
        }
        assertEquals(69, currentTarget.getValue());
    }

    @Test
    public void testIndexOf() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ill = (ImmutableLinkedList) ill.addAll(1, c);
        ill = (ImmutableLinkedList) ill.set(3, 69);
        assertEquals(3, ill.indexOf(69));
    }

    @Test
    public void testSize() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ill = (ImmutableLinkedList) ill.addAll(1, c);
        ill = (ImmutableLinkedList) ill.set(3, 69);
        assertEquals(6, ill.size());
    }

    @Test
    public void testClear() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ill = (ImmutableLinkedList) ill.addAll(1, c);
        ill = (ImmutableLinkedList) ill.clear();
        assertEquals(0, ill.size());
    }

    @Test
    public void testIsEmpty() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ill = (ImmutableLinkedList) ill.addAll(1, c);
        ill = (ImmutableLinkedList) ill.clear();
        assertEquals(true, ill.isEmpty());
    }

    @Test
    public void testToArray() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ill = (ImmutableLinkedList) ill.addAll(1, c);
        Object[] ar = {25, 26, 27, 28, 29, 10};
        assertArrayEquals(ar, ill.toArray());
    }

    @Test
    public void testToString() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ill = (ImmutableLinkedList) ill.addAll(1, c);
        assertEquals("25 26 27 28 29 10", ill.toString());
    }

    @Test
    public void TestAddFirst() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        Object[] c = {26, 27, 28, 29};
        ill = (ImmutableLinkedList) ill.addAll(1, c);
        ill = (ImmutableLinkedList) ill.addFirst(1);
        assertEquals("1 25 26 27 28 29 10", ill.toString());
    }

    @Test
    public void TestAddLast() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        assertEquals(10, ill.getRoot().getNext().getValue());
    }

    @Test
    public void TestGetFirst() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        ill = (ImmutableLinkedList) ill.add(12);
        assertEquals(25, ill.getFirst());
    }

    @Test
    public void TestGetLast() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        ill = (ImmutableLinkedList) ill.add(12);
        assertEquals(12, ill.getLast());
    }

    @Test
    public void TestRemoveFirst() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        ill = (ImmutableLinkedList) ill.add(12);
        ill = (ImmutableLinkedList) ill.removeFirst();
        assertEquals(10, ill.getFirst());
    }

    @Test
    public void TestRemoveLast() {
        ImmutableLinkedList ill = new ImmutableLinkedList(new Node(25));
        ill = (ImmutableLinkedList) ill.add(10);
        ill = (ImmutableLinkedList) ill.add(12);
        ill = (ImmutableLinkedList) ill.removeLast();
        assertEquals(10, ill.getLast());
    }
}
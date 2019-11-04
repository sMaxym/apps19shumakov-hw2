package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    
    @Test
    public void testAdd() {
        ImmutableArrayList arLst = new ImmutableArrayList(new Object[1], 0);
        arLst = (ImmutableArrayList) arLst.add(2);
        arLst = (ImmutableArrayList) arLst.add(5);
        arLst = (ImmutableArrayList) arLst.add(51);
        assertEquals(2, arLst.getData()[0]);
    }


    @Test
    public void testAddByIndex() {
        ImmutableArrayList arLst = new ImmutableArrayList(new Object[1], 0);
        arLst = (ImmutableArrayList) arLst.add(2);
        arLst = (ImmutableArrayList) arLst.add(5);
        arLst = (ImmutableArrayList) arLst.add(51);
        arLst = (ImmutableArrayList) arLst.add(1, 69);
        assertEquals(69, arLst.getData()[1]);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexException() {
        ImmutableArrayList arLst = new ImmutableArrayList(new Object[1], 0);
        arLst = (ImmutableArrayList) arLst.add(2);
        arLst = (ImmutableArrayList) arLst.add(5);
        arLst = (ImmutableArrayList) arLst.add(51);
        arLst = (ImmutableArrayList) arLst.add(100, 69);
        assertEquals(69, arLst.getData()[1]);
    }

    @Test
    public void testAddAll() {
        Object[] data = {-5, -4, -3, -2, -1};
        ImmutableArrayList arLst = new ImmutableArrayList(new Object[1], 0);
        arLst = (ImmutableArrayList) arLst.add(2);
        arLst = (ImmutableArrayList) arLst.add(5);
        arLst = (ImmutableArrayList) arLst.addAll(data);
        arLst = (ImmutableArrayList) arLst.add(51);
        arLst = (ImmutableArrayList) arLst.add(1, 69);
        assertEquals(-3, arLst.getData()[5]);
    }

    @Test
    public void testAddAllByIndex() {
        Object[] data = {-5, -4, -3, -2, -1};
        ImmutableArrayList arLst = new ImmutableArrayList(new Object[1], 0);
        arLst = (ImmutableArrayList) arLst.add(2);
        arLst = (ImmutableArrayList) arLst.add(5);
        arLst = (ImmutableArrayList) arLst.add(51);
        arLst = (ImmutableArrayList) arLst.addAll(1, data);
        arLst = (ImmutableArrayList) arLst.add(1, 69);
        assertEquals(-1, arLst.getData()[6]);
    }

    @Test
    public void testGet() {
        Object[] data = {-5, -4, -3, -2, -1};
        ImmutableArrayList arLst = new ImmutableArrayList(new Object[1], 0);
        arLst = (ImmutableArrayList) arLst.add(2);
        arLst = (ImmutableArrayList) arLst.add(5);
        arLst = (ImmutableArrayList) arLst.add(51);
        arLst = (ImmutableArrayList) arLst.addAll(1, data);
        arLst = (ImmutableArrayList) arLst.add(1, 69);
        assertEquals(-1, arLst.get(6));
    }

    @Test
    public void testRemove() {
        Object[] data = {-5, -4, -3, -2, -1};
        ImmutableArrayList arLst = new ImmutableArrayList(new Object[1], 0);
        arLst = (ImmutableArrayList) arLst.add(2);
        arLst = (ImmutableArrayList) arLst.add(5);
        arLst = (ImmutableArrayList) arLst.add(51);
        arLst = (ImmutableArrayList) arLst.addAll(1, data);
        arLst = (ImmutableArrayList) arLst.add(1, 69);
        arLst = (ImmutableArrayList) arLst.remove(3);
        assertEquals(-3, arLst.get(3));
    }

    @Test
    public void testSet() {
        Object[] data = {-5, -4, -3, -2, -1};
        ImmutableArrayList arLst = new ImmutableArrayList(new Object[1], 0);
        arLst = (ImmutableArrayList) arLst.add(2);
        arLst = (ImmutableArrayList) arLst.add(5);
        arLst = (ImmutableArrayList) arLst.add(51);
        arLst = (ImmutableArrayList) arLst.addAll(1, data);
        arLst = (ImmutableArrayList) arLst.add(1, 69);
        arLst = (ImmutableArrayList) arLst.set(3, 999999);
        assertEquals(999999, arLst.get(3));
    }

    @Test
    public void testIndexOf() {
        Object[] data = {-5, -4, -3, -2, -1};
        ImmutableArrayList arLst = new ImmutableArrayList(new Object[1], 0);
        arLst = (ImmutableArrayList) arLst.add(2);
        arLst = (ImmutableArrayList) arLst.add(5);
        arLst = (ImmutableArrayList) arLst.add(51);
        arLst = (ImmutableArrayList) arLst.addAll(1, data);
        arLst = (ImmutableArrayList) arLst.add(1, 69);
        arLst = (ImmutableArrayList) arLst.set(3, 999999);
        assertEquals(3, arLst.indexOf(999999));
    }

    @Test
    public void testToArray() {
        Object[] data = {-5, -4};
        Object[] expected = {2, -5, -4, 5, 51};
        ImmutableArrayList arLst = new ImmutableArrayList(new Object[1], 0);
        arLst = (ImmutableArrayList) arLst.add(2);
        arLst = (ImmutableArrayList) arLst.add(5);
        arLst = (ImmutableArrayList) arLst.add(51);
        arLst = (ImmutableArrayList) arLst.addAll(1, data);
        assertArrayEquals(expected, arLst.toArray());
    }

    @Test
    public void testToString() {
        Object[] data = {-5, -4};
        ImmutableArrayList arLst = new ImmutableArrayList(new Object[1], 0);
        arLst = (ImmutableArrayList) arLst.add(2);
        arLst = (ImmutableArrayList) arLst.add(5);
        arLst = (ImmutableArrayList) arLst.add(51);
        arLst = (ImmutableArrayList) arLst.addAll(1, data);
        assertEquals("2 -5 -4 5 51", arLst.toString());
    }
    
}

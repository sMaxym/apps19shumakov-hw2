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
    
}

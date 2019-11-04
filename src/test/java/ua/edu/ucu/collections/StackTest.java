package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPush() {
        Stack s = new Stack();
        s.push(1);
        assertEquals(1, s.peek());
    }

    @Test
    public void testPop() {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.pop();
        assertEquals(1, s.peek());
    }

    @Test
    public void testPeek() {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        assertEquals(2, s.peek());
    }
    
}

package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testEnqueue() {
        Queue q = new Queue();
        q.enqueue(1);
        assertEquals(1, q.peek());
    }

    @Test
    public void testDequeue() {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        assertEquals(2, q.peek());
    }

    @Test
    public void testPeek() {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        assertEquals(1, q.peek());
    }

}

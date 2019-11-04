package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList data;

    public Queue() {
        data = new ImmutableLinkedList();
    }

    public Object peek() {
        return data.getFirst();
    }

    public Object dequeue() {
        Object val = peek();
        data = (ImmutableLinkedList) data.removeFirst();
        return val;
    }

    public void enqueue(Object e) {
        data = (ImmutableLinkedList) data.addLast(e);
    }
}

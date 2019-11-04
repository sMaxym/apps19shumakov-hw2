package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList data;

    public Stack() {
        data = new ImmutableLinkedList();
    }

    public Object peek() {
        return data.getLast();
    }

    public Object pop() {
        Object val = data.getLast();
        data = (ImmutableLinkedList) data.removeLast();
        return val;
    }

    public void push(Object e) {
        data = (ImmutableLinkedList) data.addLast(e);
    }
}

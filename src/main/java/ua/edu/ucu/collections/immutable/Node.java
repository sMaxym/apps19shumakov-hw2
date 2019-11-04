package ua.edu.ucu.collections.immutable;

public class Node {
    private Node next;
    private Object value;

    public Node(Object value, Node next) {
        this.setValue(value);
        this.setNext(next);
    }

    public Node(Object value) {
        this.setValue(value);
    }

    public void setValue(Object val) {
        value = val;
    }

    public Object getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }
}

package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList{

    private Node root;
    private int size;

    public ImmutableLinkedList() {
        this.root = null;
        this.size = 0;
    }

    public ImmutableLinkedList(Object root) {
        this.root = new Node(root);
        this.size = 1;
    }

    public ImmutableLinkedList(ImmutableLinkedList instance) {
        this.root = instance.getRoot();
        this.size = instance.size();
    }

    public Node getRoot() {
        return root;
    }

    public void incrementSize() {
        size += 1;
    }

    @Override
    public ImmutableList add(Object e) {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
        if (linkedList.getRoot() == null) {
            linkedList = new ImmutableLinkedList(e);
            return linkedList;
        }
        Node currentTarget = linkedList.getRoot();
        for (int i = 1; i < linkedList.size(); i++) {
            currentTarget = currentTarget.getNext();
        }
        currentTarget.setNext(new Node(e));
        linkedList.incrementSize();
        return linkedList;
    }

    @Override
    public ImmutableList add(int index, Object e) throws IndexOutOfBoundsException {
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
        linkedList.incrementSize();
        Node currentTarget = linkedList.getRoot();
        for (int i = 0; i < index; i++) {
            currentTarget = currentTarget.getNext();
        }
        currentTarget.setValue(e);
        return linkedList;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return null;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        return null;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}

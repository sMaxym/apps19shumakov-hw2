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

    public void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node e) {
        this.root = e;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void incrementSize() {
        size += 1;
    }

    private ImmutableList addNode(Node n, int size) {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
        if (size == 0) {
            return linkedList;
        }
        if (linkedList.getRoot() == null) {
            linkedList = new ImmutableLinkedList(n.getValue());
            return linkedList;
        }
        Node currentTarget = linkedList.getRoot();
        for (int i = 1; i < linkedList.size(); i++) {
            currentTarget = currentTarget.getNext();
        }
        currentTarget.setNext(n);
        for (int i = 0; i < size; ++i) {
            linkedList.incrementSize();
        }
        return linkedList;
    }

    private ImmutableList addNode(Node n, int index, int size) throws IndexOutOfBoundsException {
        checkIndex(index);
        ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
        if (size == 0) {
            return linkedList;
        }
        Node currentTarget, address;
        currentTarget = linkedList.getRoot();
        for (int i = 1; i < index; i++) {
            currentTarget = currentTarget.getNext();
        }
        address = currentTarget.getNext();
        currentTarget.setNext(n);
        for (int i = 0; i < size; ++i) {
            linkedList.incrementSize();
            currentTarget = currentTarget.getNext();
        }
        currentTarget.setNext(address);
        return linkedList;
    }

    @Override
    public ImmutableList add(Object e) {
        return addNode(new Node(e), 1);
    }

    @Override
    public ImmutableList add(int index, Object e) throws IndexOutOfBoundsException {
        return addNode(new Node(e), index, 1);
    }

    private Node buildSequence(Object[] c) {
        int len = c.length;
        if (len == 0) {
            return null;
        }
        Node root = new Node(c[0]);
        Node currentTarget = root;
        for (int i = 1; i < len; ++i) {
            currentTarget.setNext(new Node(c[i]));
            currentTarget = currentTarget.getNext();
        }
        return root;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Node objSequence = buildSequence(c);
        return addNode(objSequence, c.length);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Node objSequence = buildSequence(c);
        return addNode(objSequence, index, c.length);
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        Node currentTarget = getRoot();
        for (int i = 0; i < index; i++) {
            currentTarget = currentTarget.getNext();
        }
        return currentTarget.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        checkIndex(index);
        ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
        Node currentTarget = linkedList.getRoot();
        for (int i = 0; i < index - 1; ++i) {
            currentTarget = currentTarget.getNext();
        }
        currentTarget.setNext(currentTarget.getNext().getNext());
        linkedList.setSize(linkedList.size() - 1);
        return linkedList;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        checkIndex(index);
        ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
        Node currentTarget = linkedList.getRoot();
        for (int i = 0; i < index; ++i) {
            currentTarget = currentTarget.getNext();
        }
        currentTarget.setValue(e);
        return linkedList;
    }

    @Override
    public int indexOf(Object e) {
        Node currentTarget = getRoot();
        int lookedIndex = -1;
        for (int i = 0; i < size(); i++) {
            if (currentTarget.getValue() == e) {
                lookedIndex = i;
                break;
            }
            currentTarget = currentTarget.getNext();
        }
        return lookedIndex;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] ar = new Object[size()];
        Node currentTarget = getRoot();
        for (int i = 0; i < ar.length; ++i) {
            ar[i] = currentTarget.getValue();
            currentTarget = currentTarget.getNext();
        }
        return ar;
    }

    @Override
    public String toString() {
        String representation = "";
        Node currentTarget = getRoot();
        for (int i = 0; i < size(); i++) {
            representation += currentTarget.getValue().toString();
            currentTarget = currentTarget.getNext();
            if (i != size - 1) {
                representation += " ";
            }
        }
        return representation;
    }
}

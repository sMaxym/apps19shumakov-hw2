package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {

    private Node root;
    private int size;

    public ImmutableLinkedList() {
        this.root = null;
        this.size = 0;
    }

    public ImmutableLinkedList(Node root) {
        this.root = root;
        this.size = 1;
    }

    public ImmutableLinkedList(ImmutableLinkedList instance) {
        this.root = new Node(instance.getRoot());
        this.size = instance.size();
    }

    public void checkIndex(int index, int size) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public ImmutableList add(Object e) {
        ImmutableLinkedList linkedList;
        if (root == null) {
            return new ImmutableLinkedList(new Node(e));
        }
        linkedList = new ImmutableLinkedList(this);
        Node currentTarget = linkedList.getRoot();
        while (currentTarget.getNext() != null) {
            currentTarget = currentTarget.getNext();
        }
        currentTarget.setNext(new Node(e));
        linkedList.setSize(linkedList.size + 1);
        return linkedList;
    }

    @Override
    public ImmutableList add(int index, Object e) throws IndexOutOfBoundsException {
        checkIndex(index, size + 1);
        ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
        Node currentTarget = linkedList.getRoot();
        if (index == 0) {
            Node newRoot = new Node(e, currentTarget);
            linkedList = new ImmutableLinkedList(newRoot);
            linkedList.setSize(size + 1);
            return linkedList;
        }
        for (int i = 0; i < index - 1; i++) {
            currentTarget = currentTarget.getNext();
        }
        Node address = currentTarget.getNext();
        Node toInsert = new Node(e, address);
        currentTarget.setNext(toInsert);
        linkedList.setSize(linkedList.size + 1);
        return linkedList;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
        for (Object el : c) {
            linkedList = (ImmutableLinkedList) linkedList.add(el);
        }
        return linkedList;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        ImmutableLinkedList linkedList = new ImmutableLinkedList(this);
        for (Object el : c) {
            linkedList = (ImmutableLinkedList) linkedList.add(index, el);
            index += 1;
        }
        return linkedList;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        Node currentTarget = getRoot();
        for (int i = 0; i < index; i++) {
            currentTarget = currentTarget.getNext();
        }
        return currentTarget.getValue();
    }

    @Override
    public ImmutableList remove(int index) throws IndexOutOfBoundsException {
        Node currentTarget = root;
        ImmutableLinkedList ll = new ImmutableLinkedList();
        for (int i = 0; i < size(); ++i) {
            if (i == index) {
                currentTarget = currentTarget.getNext();
                continue;
            }
            if (ll.getRoot() == null) {
                ll = new ImmutableLinkedList(new Node(currentTarget.getValue()));
            } else {
                ll = (ImmutableLinkedList) ll.add(currentTarget.getValue());
            }
            currentTarget = currentTarget.getNext();
        }
        return ll;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        checkIndex(index, size);
        Node currentTarget = root;
        for (int i = 0; i < index; ++i) {
            currentTarget = currentTarget.getNext();
        }
        currentTarget.setValue(e);
        ImmutableLinkedList linkedList = new ImmutableLinkedList(root);
        linkedList.setSize(size);
        return linkedList;
    }

    @Override
    public int indexOf(Object e) {
        Node currentTarget = getRoot();
        int lookedIndex = -1;
        for (int i = 0; i < size(); i++) {
            if (currentTarget.getValue().hashCode() == e.hashCode()) {
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

    public ImmutableList addFirst(Object e) {
        ImmutableLinkedList linkedList = (ImmutableLinkedList) add(0, e);
        return linkedList;
    }

    public ImmutableList addLast(Object e) {
        ImmutableLinkedList linkedList = (ImmutableLinkedList) add(e);
        return linkedList;
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(size - 1);
    }

    public ImmutableList removeFirst() {
        return remove(0);
    }

    public ImmutableList removeLast() {
        return remove(size - 1);
    }
}

package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {

    private int size;
    private int capacity;
    private Object[] data;

    public ImmutableArrayList(Object[] data, int size) {
        this.size = size;
        this.capacity = data.length;
        this.data = data;
    }

    public ImmutableArrayList(ImmutableArrayList instance) {
        capacity = instance.getCapacity();
        size = instance.size();
        data = instance.getData();
    }

    public void checkIndex(int index, int size) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public Object[] getData() {
        return data;
    }

    @Override
    public ImmutableList add(Object e) {
        int newCapacity = this.capacity;
        if (this.size == this.capacity) {
            newCapacity = this.capacity * 2;
        }
        Object[] elms = Arrays.copyOf(this.data, newCapacity);
        elms[this.size] = e;
        ImmutableArrayList arrayList = new ImmutableArrayList(elms, size + 1);
        return arrayList;
    }

    @Override
    public ImmutableList add(int index, Object e) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        int newCapacity = this.capacity;
        if (this.size == this.capacity) {
            newCapacity = this.capacity * 2;
        }
        Object[] elms = Arrays.copyOf(this.data, newCapacity);
        for (int i = size; i > index; --i) {
            elms[i] = elms[i - 1];
        }
        elms[index] = e;
        ImmutableArrayList arrayList = new ImmutableArrayList(elms, size + 1);
        return arrayList;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        ImmutableArrayList arrayList = new ImmutableArrayList(this);
        for (Object el : c) {
            arrayList = (ImmutableArrayList) arrayList.add(el);
        }
        return arrayList;
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
    public ImmutableList set(int index, Object e) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        ImmutableArrayList arrayList;
        if (size == capacity) {
            arrayList = new ImmutableArrayList(this);
        } else {
            arrayList = new ImmutableArrayList(this);
        }
        arrayList.getData()[index] = e;
        return arrayList;
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
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}

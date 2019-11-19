package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {

    private int size;
    private int capacity;
    private Object[] data;

    public ImmutableArrayList() {
        this.size = 0;
        this.capacity = 0;
        this.data = new Object[0];
    }

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

    private int calcCapacity(int size, int capacity) {
        int newCapacity = this.capacity;
        if (capacity == 0) {
            newCapacity = 2;
        } else if (this.size == this.capacity) {
            newCapacity = this.capacity * 2;
        }
        return newCapacity;
    }

    @Override
    public ImmutableList add(Object e) {
        int newCapacity = calcCapacity(size, capacity);
        Object[] elms = Arrays.copyOf(this.data, newCapacity);
        elms[this.size] = e;
        ImmutableArrayList arrayList = new ImmutableArrayList(elms, size + 1);
        return arrayList;
    }

    @Override
    public ImmutableList add(int index, Object e) throws IndexOutOfBoundsException {
        checkIndex(index, size + 1);
        int newCapacity = calcCapacity(size, capacity);
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
        ImmutableArrayList arrayList = new ImmutableArrayList(this);
        for (Object el : c) {
            arrayList = (ImmutableArrayList) arrayList.add(index, el);
            index += 1;
        }
        return arrayList;    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        return data[index];
    }

    @Override
    public ImmutableList remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        Object[] elms = Arrays.copyOf(this.data, this.capacity);
        for (int i = index; i < size() - 1; i++) {
            elms[i] = elms[i + 1];
        }
        ImmutableArrayList arrayList = new ImmutableArrayList(elms, size - 1);
        return arrayList;
    }

    @Override
    public ImmutableList set(int index, Object e) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        Object[] elms = Arrays.copyOf(this.data, this.capacity);
        elms[index] = e;
        ImmutableArrayList arrayList = new ImmutableArrayList(elms, size);
        return arrayList;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; ++i) {
            if (data[i].hashCode() == e.hashCode()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList(new Object[capacity], 0);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.data, this.size);
    }

    @Override
    public String toString() {
        String output = "";
        Object[] elms = Arrays.copyOf(this.data, this.capacity);
        for (int i = 0; i < size; ++i) {
            output += data[i].toString();
            if (i != size - 1) {
                output += " ";
            }
        }
        return output;
    }
}

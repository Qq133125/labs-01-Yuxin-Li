package utils;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(E item) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size] = item;
        size++;
        return true;
    }

    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == elements.length) {
            ensureCapacity();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
    }

    @Override
    public boolean remove(E item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(elements[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E removedElement = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size - 1] = null;
        size--;
        return removedElement;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elements[index];
    }

    @Override
    public void set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        elements[index] = item;
    }

    private void ensureCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }
    
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }
    public class ArrayIterator implements Iterator<E> {
        private int index;   // µ±«∞Œª÷√

        public ArrayIterator() {
            index = 0;
        }

        public boolean hasNext() {
            return index < size();
        }

        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = get(index);
            index++;
            return result;
        }

        
        public void remove() throws IllegalStateException {
            if (index == 0) {
                throw new IllegalStateException();
            }
            ArrayList.this.remove(index - 1);
            index--;
        }
    }
}

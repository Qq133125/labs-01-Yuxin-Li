package utils;

import java.util.NoSuchElementException;

public interface List<E> {

    int size();

    boolean isEmpty();

    boolean contains(E item);

    boolean add(E item);

    void add(int index, E item);

    boolean remove(E item);

    E remove(int index);

    E get(int index);

    void set(int index, E item);

    default void addFirst(E item) {
        add(0, item);
    }

    default void addLast(E item) {
        add(size(), item);
    }

    default E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(0);
    }

    default E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size() - 1);
    }

    default E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return remove(0);
    }

    default E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return remove(size() - 1);
    }
}

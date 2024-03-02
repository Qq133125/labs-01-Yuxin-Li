package utils;

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E> {

    private Node<E> head;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E item) {
            this.item = item;
        }
    }

    public LinkedList() {
        head = null;
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
        Node<E> current = head;
        while (current != null) {
            if (item.equals(current.item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean add(E item) {
        add(size, item);
        return true;
    }

    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> newNode = new Node<>(item);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(E item) {
        Node<E> prev = null;
        Node<E> current = head;
        while (current != null) {
            if (item.equals(current.item)) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        if (index == 0) {
            head = current.next;
        } else {
            Node<E> prev = getNode(index - 1);
            current = prev.next;
            prev.next = current.next;
        }
        size--;
        return current.item;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = getNode(index);
        return node.item;
    }

    @Override
    public void set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = getNode(index);
        node.item = item;
    }

    private Node<E> getNode(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void addFirst(E item) {
        add(0, item);
    }

    @Override
    public void addLast(E item) {
        add(size(), item);
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(0);
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return get(size() - 1);
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return remove(0);
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return remove(size() - 1);
    }
    public Iterator<E> iterator() {
        return new LinkedIterator();
    }
    private class LinkedIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            // Implement if needed
            throw new UnsupportedOperationException();
        }
    }
    
}

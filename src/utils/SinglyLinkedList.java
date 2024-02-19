package utils;

public class SinglyLinkedList<T> {
    private Node<T> first;
    private int size;

    public SinglyLinkedList() {
        this.first = null;
        this.size = 0;
    }

    public boolean add(T item) {
        append(item);
        return true;
    }

    public void add(int index, T item) {
        if (index == size) {
            append(item);
        } else {
            insertBefore(index, item);
        }
    }

    private void append(T item) {
        if (isEmpty()) {
            first = new Node<>(item);
        } else {
            Node<T> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(item);
        }
        size++;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private T detach(int index) {
        checkIndex(index);

        Node<T> previous = null;
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = current.next;
        } else {
            previous.next = current.next;
        }
        size--;
        return current.data;
    }

    public T get(int index) {
        checkIndex(index);
        Node<T> node = node(index);
        return node.data;
    }

    private void insertBefore(int index, T item) {
        if (index == 0) {
            first = new Node<>(item, first);
        } else {
            Node<T> previous = node(index - 1);
            Node<T> newNode = new Node<>(item, previous.next);
            previous.next = newNode;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<T> node(int index) {
        checkIndex(index);
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public T remove(int index) {
        return detach(index);
    }

    public T set(int index, T item) {
        checkIndex(index);
        Node<T> node = node(index);
        T oldData = node.data;
        node.data = item;
        return oldData;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = first;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}

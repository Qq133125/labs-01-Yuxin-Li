package utils;

import java.util.NoSuchElementException;

public class MyQueue<E> {

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyQueue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean add(E item) {
        append(item);
        size++;
        return true;
    }

    private void append(E item) {
        Node<E> newNode = new Node<>(item);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    private E detach() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        E data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public E remove() {
        E data = detach();
        size--;
        return data;
    }

    public E peek() {
        if (first == null) {
            return null;
        }
        return first.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = first;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

package utils;

import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack<E> {
    private Node<E> first;
    private int size;

    public MyStack() {
        first = null;
        size = 0;
    }

    public E push(E item) {
        Node<E> newNode = new Node<>(item, first);
        first = newNode;
        size++;
        return item;
    }

    private E detach() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E data = first.data;
        first = first.next;
        size--;
        return data;
    }

    public E pop() {
        return detach();
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
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
        Stack<E> tempStack = new Stack<>();
        while (current != null) {
            tempStack.push(current.data);
            current = current.next;
        }

        while (!tempStack.isEmpty()) {
            sb.append(tempStack.pop());
            if (!tempStack.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}

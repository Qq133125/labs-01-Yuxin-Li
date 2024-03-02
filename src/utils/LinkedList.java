package utils;

public class LinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean add(E item) {
        append(item);
        size++;
        return true;
    }

    public void add(int index, E item) {
        checkIndex(index);
        insertBefore(index, item);
        size++;
    }

    private void append(E item) {
        Node<E> newNode = new Node<>(last, item, null);
        if (last == null) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public boolean contains(E item) {
        return indexOf(item) != -1;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private E detach(int index) {
        Node<E> node = node(index);
        if (node == first) {
            first = node.next;
        } else {
            node.prev.next = node.next;
        }
        if (node == last) {
            last = node.prev;
        } else {
            node.next.prev = node.prev;
        }
        return node.data;
    }

    public E get(int index) {
        checkIndex(index);
        return node(index).data;
    }

    public int indexOf(E item) {
        Node<E> current = first;
        for (int i = 0; i < size; i++) {
            if (current.data.equals(item)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    private void insertBefore(int index, E item) {
        if (index == size) {
            append(item);
            return;
        }
        Node<E> node = node(index);
        Node<E> newNode = new Node<>(node.prev, item, node);
        if (node == first) {
            first = newNode;
        } else {
            node.prev.next = newNode;
        }
        node.prev = newNode;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<E> node(int index) {
        checkIndex(index);
        if (index < size / 2) {
            Node<E> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            Node<E> current = last;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }

    public E remove(int index) {
        checkIndex(index);
        E removed = detach(index);
        size--;
        return removed;
    }

    public boolean remove(E item) {
        int index = indexOf(item);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public E set(int index, E item) {
        checkIndex(index);
        Node<E> node = node(index);
        E replaced = node.data;
        node.data = item;
        return replaced;
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = first;
        for (int i = 0; i < size; i++) {
            sb.append(current.data);
            if (i < size - 1) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(Node<E> prev, E data) {
            this(prev, data, null);
        }

        public Node(Node<E> prev, E data, Node<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}

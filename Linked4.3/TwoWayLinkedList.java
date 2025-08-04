import java.util.*;

public class TwoWayLinkedList<E> implements java.util.Collection<E> {
    private Node<E> head, tail;
    private int size = 0;

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Inner Node class
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E e) {
            this.element = e;
        }
    }

    public TwoWayLinkedList() {}

    public TwoWayLinkedList(E[] objects) {
        for (E e : objects)
            add(e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();

        Node<E> newNode = new Node<>(e);

        if (index == 0) {
            newNode.next = head;
            if (head != null) head.previous = newNode;
            head = newNode;
            if (tail == null) tail = head;
        } else if (index == size) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) current = current.next;
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
        }
        size++;
    }

    public boolean add(E e) {
        add(size, e);
        return true;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public boolean contains(Object e) {
        return indexOf(e) != -1;
    }

    public E get(int index) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.element;
    }

    public int indexOf(Object e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(current.element, e)) return i;
            current = current.next;
        }
        return -1;
    }

    public int lastIndexOf(Object e) {
        Node<E> current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(current.element, e)) return i;
            current = current.previous;
        }
        return -1;
    }

    public E remove(int index) {
        checkIndex(index);
        Node<E> removed;

        if (index == 0) {
            removed = head;
            head = head.next;
            if (head != null) head.previous = null;
            if (index == size - 1) tail = null;
        } else if (index == size - 1) {
            removed = tail;
            tail = tail.previous;
            tail.next = null;
        } else {
            removed = head;
            for (int i = 0; i < index; i++) removed = removed.next;
            removed.previous.next = removed.next;
            removed.next.previous = removed.previous;
        }

        size--;
        return removed.element;
    }

    public boolean remove(Object e) {
        int index = indexOf(e);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    public E set(int index, E e) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        E old = current.element;
        current.element = e;
        return old;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
    }

    public java.util.ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public java.util.ListIterator<E> listIterator(int index) {
        checkIndex(index);
        return new ListIteratorImpl(index);
    }

    private class ListIteratorImpl implements ListIterator<E> {
        private Node<E> current;
        private int index;

        public ListIteratorImpl(int index) {
            this.index = index;
            current = head;
            for (int i = 0; i < index; i++)
                current = current.next;
        }

        @Override public boolean hasNext() { return current != null && current.next != null; }
        @Override public E next() {
            E value = current.element;
            current = current.next;
            index++;
            return value;
        }
        @Override public boolean hasPrevious() { return current != null && current.previous != null; }
        @Override public E previous() {
            current = current.previous;
            index--;
            return current.element;
        }
        @Override public int nextIndex() { return index; }
        @Override public int previousIndex() { return index - 1; }
        @Override public void remove() { throw new UnsupportedOperationException(); }
        @Override public void set(E e) { throw new UnsupportedOperationException(); }
        @Override public void add(E e) { throw new UnsupportedOperationException(); }
    }

    @Override public boolean isEmpty() { return size == 0; }
    @Override public Object[] toArray() { throw new UnsupportedOperationException(); }
    @Override public <T> T[] toArray(T[] a) { throw new UnsupportedOperationException(); }
    @Override public boolean containsAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public boolean addAll(Collection<? extends E> c) { throw new UnsupportedOperationException(); }
    @Override public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException(); }
}
package billionaire.nitin.kumar.gupta.doubleLinkedList;

public class DoublyLinkedList<T extends Comparable<T>> {
    private int size;
    private Node<T> head, tail;

    public void addAtLast(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            Node<T> tmp = tail;
            tmp.next = node;
            node.prev = tmp;
            tail = node;
        }
        size++;
    }

    public void addAtPosition(int position, T data) {
        if (position == 0) addAtFirst(data);
        else if (position == size + 1) addAtLast(data);
        else if (position > size + 1) throw new IndexOutOfBoundsException();
        else {
            Node<T> node = new Node<>(data);
            Node<T> tmp = head;
            for (int i = 1; i < position - 1; i++) tmp = tmp.next;
            Node<T> ptr = tmp;
            Node<T> ptrNext = tmp.next;
            ptr.next = node;
            node.prev = ptr;
            node.next = ptrNext;
            ptrNext.prev = node;
            size++;
        }
    }

    public void removeAtFirst() {
        if (head == null) return;
        Node<T> tmp = head.next;
        head = tmp;
        tmp.prev = null;
        size--;
    }

    public void removeAtLast() {
        if (tail == null) return;
        Node<T> tmp = tail.prev;
        tmp.next = null;
        tail = tmp;
        size--;
    }

    public void removeAtPosition(int position) {
        if (position == 0) removeAtFirst();
        else if (position == size) removeAtLast();
        else if (position > size) throw new IndexOutOfBoundsException();
        else {
            Node<T> tmp = head;
            for (int i = 1; i < position ; i++) tmp = tmp.next;
            Node ptr =tmp.prev;
            Node ptrNext =tmp.next ;
            ptr.next=ptrNext;
            ptrNext.prev=ptr;
            size--;
        }
    }

    private static class Node<T extends Comparable<T>> {
        Node<T> next, prev;
        T data;

        @Override
        public String toString() {
            return "{ " + data + '}';
        }

        Node(T data) {
            this.data = data;
        }
    }

    public void addAtFirst(T data) {
        Node<T> node = new Node(data);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            Node tmp = head;
            node.next = tmp;
            tmp.prev = node;
            head = node;
        }
        size++;
    }

    public void printAll() {
        Node<T> tmp = head;
        System.out.println();
        while (tmp != null) {
            System.out.print(" " + tmp);
            tmp = tmp.next;
        }
    }

    public void printBackAll() {
        System.out.println();
        Node<T> tmp = tail;
        while (tmp != null) {
            System.out.print(" " + tmp);
            tmp = tmp.prev;
        }
    }


}

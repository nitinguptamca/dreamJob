package billionaire.nitin.kumar.gupta.singleList;

public class SingleLinkedListNit {

    int size = 0;
    private Node head, tail;

    public Node getMiddleNode() {
        Node slowPointer = head;
        Node fasterPointer = head.next;
        while (fasterPointer != null) {
            fasterPointer = fasterPointer.next;
            if (fasterPointer != null && fasterPointer.next != null) {
                fasterPointer = fasterPointer.next;
                slowPointer = slowPointer.next;
            }
        }
        return slowPointer;
    }

    public void deleteAtMiddle() {
        Node middleNode = getMiddleNode();
        middleNode.next = middleNode.next.next;
        size--;
    }

    public void addAtMiddle(int data) {
        Node node = new Node(data);
        Node middleNode = getMiddleNode();
        Node ptr = middleNode;
        Node ptrNext = middleNode.next;
        ptr.next = node;
        node.next = ptrNext;
        size++;
    }

    public void removeAtNthNodeFromLast(int position) {
        if (head == null) return;
        else if (position > size) System.out.println("Number of element is less then expected");
        else if (position == 0) deleteAtLast();
        else if (position == size) deleteAtFirst();
        else {
            Node tmp = head;
            Node s = head;
            int count = 1;
            while (tmp != null) {
                if (count <= position) {
                    tmp = tmp.next;
                } else {
                    tmp = tmp.next;
                    s = s.next;
                }
            }
            s.next = s.next.next;
            size--;
        }
    }

    public void reverseOrder() {
        Node next = null, prev = null;
        Node current = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }


    public void removeDuplcate() {
        Node tmp = head;
        while (tmp != null) {
            Node ptr = tmp;
            while (ptr != null && ptr.next != null) {
                if (tmp.data == ptr.next.data) {
                    ptr.next = ptr.next.next;
                }
                ptr = ptr.next;
            }
            tmp = tmp.next;
        }
    }

    public void bubbleSort() {
        Node tmp = head;
        while (tmp != null) {
            Node ptr = tmp.next;
            while (ptr != null) {
                if (tmp.data > ptr.data) {
                    int temp = tmp.data;
                    tmp.data = ptr.data;
                    ptr.data = temp;
                }
                ptr = ptr.next;
            }
            tmp = tmp.next;
        }
    }

    private void swap(int data, int data1) {
        int temp = data;
        data = data1;
        data1 = temp;
    }

    public void insertionSort() {


    }

    public void addAtFirst(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
        } else {
            Node tmp = head;
            node.next = tmp;
            head = node;
        }
        size++;
    }

    public void addAtLast(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
        } else {
            Node tmp = tail;
            tmp.next = node;
            tail = node;
        }
        size++;
    }

    public void addAtPosition(int position, int data) {
        if (position == 0) addAtFirst(data);
        else if (position == size + 1) addAtLast(data);
        else if (position > size + 1) throw new IndexOutOfBoundsException();
        else {
            Node tmp = head;
            for (int i = 1; i < position - 1; i++) {
                tmp = tmp.next;
            }
            Node ptr = tmp;
            Node ptrNext = tmp.next;
            Node node = new Node(data);
            ptr.next = node;
            node.next = ptrNext;
            size++;
        }
    }

    public void deleteAtLast() {
        if (head == null) return;
        Node s = head;
        Node t = head;
        while (s.next != null) {
            t = s;
            s = s.next;

        }
        tail = t;
        tail.next = null;
        size--;
    }

    public void deleteAtFirst() {
        if (head == null) return;
        Node tmp = head.next;
        head = tmp;
        size--;
    }

    public void deleteAtPosition(int position) {
        if (0 == position) deleteAtFirst();
        else if (size == position) deleteAtLast();
        else if (size < position) throw new IndexOutOfBoundsException();
        else {
            Node tmp = head;
            for (int i = 1; i < position - 1; i++) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
            size--;
        }
    }

    public void printAll() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(" " + tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
    }

    private static class Node {
        private Node next, prev;
        private int data;

        Node(int data) {
            this.data = data;
        }
    }
}

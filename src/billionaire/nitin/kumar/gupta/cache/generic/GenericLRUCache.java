package billionaire.nitin.kumar.gupta.cache.generic;

import java.util.HashMap;

public class GenericLRUCache<T> {
    int maxSize = 4;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head, tail;

    public void show() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp);
            tmp = tmp.next;
        }
        System.out.println();
    }


    public void put(int key, int value) {
        Node<T> newNode = new Node(key, value);
        if (map.containsKey(key)) {
            Node node = map.get(key);
            map.put(key, newNode);
            delete(node);
            addAtTop(newNode);
        } else {
            if (map.size() > maxSize) {
                map.remove(tail.key);
                delete(tail);
                addAtTop(newNode);
                map.put(key, newNode);
                return;
            } else {
                addAtTop(newNode);
                map.put(key, newNode);
            }
        }
    }

    private void delete(Node<T> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

    }

    private Node get(int key) {
        Node<T> node = map.get(key);
        return node;
    }

    public void addAtTop(Node<T> node) {
        if (head == null) {
            head = node;
            tail = null;
        } else {
            Node<T> tmp = head;
            node.next = tmp;
            tmp.prev = node;
            head = node;
        }
    }

    private class Node<T> {
        int key;
        T value;
        Node next, prev;

        public Node(int key, T value) {
            this.key = key;
            this.value = value;
            next = prev = null;
        }

        @Override
        public String toString() {
            return "{ key=" + key + ", data=" + value + '}';
        }

    }
}

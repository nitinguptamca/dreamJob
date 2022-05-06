package billionaire.nitin.kumar.gupta.doubleLinkedList;

public class TestingDLL {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.addAtFirst(10);
        dll.addAtFirst(20);
        dll.addAtFirst(30);
        dll.addAtFirst(40);
        dll.addAtLast(10);
        dll.addAtLast(20);
        dll.addAtLast(30);
        dll.addAtLast(40);
        dll.addAtPosition(2, 10);
        dll.addAtPosition(10, 20);
        dll.addAtPosition(0, 10);
        ///dll.addAtPosition(100, 20);
        dll.printAll();
        dll.printBackAll();
        dll.removeAtPosition(2);
        dll.printAll();
        dll.printBackAll();
        dll.removeAtPosition(6);
        dll.printAll();
        dll.printBackAll();
       // dll.deleteNode(10);


    }
}

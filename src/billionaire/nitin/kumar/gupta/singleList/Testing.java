package billionaire.nitin.kumar.gupta.singleList;

public class Testing {
    public static void main(String[] args) {
        SingleLinkedList testing = new SingleLinkedList();
        testing.addAtFirst(10);
        testing.addAtFirst(20);
        testing.addAtFirst(30);
        testing.addAtLast(40);
        testing.addAtLast(50);
        testing.addAtLast(60);
        testing.addAtPosition(0, 1);
        testing.addAtPosition(8, 80);
        testing.addAtPosition(5, 45);
        testing.addAtFirst(10);
        testing.addAtFirst(20);
        testing.addAtFirst(30);
        testing.addAtLast(40);
        testing.addAtLast(50);
        testing.addAtLast(60);
        testing.addAtPosition(0, 1);
        testing.addAtPosition(8, 80);
        testing.addAtPosition(5, 45);
        System.out.println("**********************");
        testing.printAll();
        testing.removeDuplcate();
        testing.printAll();
        System.out.println("after bubble sort");
        testing.bubbleSort();
        System.out.println("after insertion sort");
        // testing.insertionSort();
        testing.printAll();
    }
}

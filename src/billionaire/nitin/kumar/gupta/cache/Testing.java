package billionaire.nitin.kumar.gupta.cache;

public class Testing {
    public static void main(String[] args) {
        LRUCache demo1 = new LRUCache();
        demo1.put(1, 1);
        demo1.put(2, 2);
        demo1.put(3, 3);
        demo1.put(4, 4);
        demo1.put(5, 5);
        demo1.show();
        demo1.put(1, 7);
        demo1.put(8, 3);
        demo1.put(13, 21);
        demo1.put(1, 19);
        demo1.show();
        demo1.put(10, 10);
        demo1.put(31, 111);
        demo1.show();
        demo1.put(21, 21);
        demo1.put(11, 11);
        demo1.show();
    }
}

package revision.BST;

public class TestingBST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(25);
        bst.insert(20);
        bst.insert(15);
        bst.insert(5);
        bst.insert(10);
        bst.insert(30);
        bst.insert(35);
        bst.insert(40);
        bst.insert(18);
        bst.insert(22);
        bst.insert(23);
        bst.insert(28);
        bst.insert(33);
        bst.insert(31);
        bst.insert(38);

        bst.inOrderTraversal(bst.getRoot());
        System.out.println();
        System.out.println();
        System.out.println("get max value" + bst.getMax(bst.getRoot()));
        System.out.println("get min value" + bst.getMin(bst.getRoot()));
        System.out.println("print leave node");
        bst.printLeafNode(bst.getRoot());
        System.out.println("\n is node present " + bst.isNodePresent(15));
        System.out.println("number of node in tree  " + bst.countNode(bst.getRoot()));
        System.out.println("Height of tree  " + bst.height(bst.getRoot()));
       bst.levelOrderTraverse(bst.getRoot());


    }

}

package billionaire.nitin.kumar.gupta.tree;

public class BSTTesting {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(25);
        bst.insert(20);
        bst.insert(30);
        bst.insert(15);
        bst.insert(5);
        bst.insert(1);
        bst.insert(17);
        bst.insert(19);
        bst.insert(35);
        bst.insert(26);
        bst.insert(27);
        bst.insert(31);
        bst.insert(33);
        //Left-root_right
        bst.preOrderTraversal();
        System.out.println();
        /*bst.inOrderTraversal();
        System.out.println();
        bst.postOrderTraversal();
        System.out.println();
        bst.delete(30);
        bst.postOrderTraversal();*/
        // System.out.println("Max value of root "+bst.getMaxValue());
        // System.out.println("Min value of root "+bst.getMinValue());
        //   System.out.println("Max value of root "+bst.findLargestValue(bst.getRoot()));
        // System.out.println("Min value of root "+bst.findSmallestValue(bst.getRoot()));
        //  System.out.println("is node is present --> " + bst.searchData(135));
        //  System.out.println("count node --> "+ bst.countNode(bst.getRoot()));
        System.out.println("print leaf node ");
        bst.printLeafNodes(bst.getRoot());
         System.out.println("height of tree " + bst.height(bst.getRoot()));
        /// System.out.println("get Max depth  " +bst.maxDepth(bst.getRoot()));
        // System.out.println("get Min depth  " +bst.minDepth(bst.getRoot()));
        //System.out.println("is tree balance " + bst.isBalanced(bst.getRoot()));
        System.out.println("********************");
        // bst.levelOrderTraverse(bst.getRoot());
        System.out.println();
        // bst.mirror(bst.getRoot());
        //    bst.printLeafNodes(bst.getRoot());
        System.out.println("is identical    " + bst.identicalTrees(bst.getRoot(), bst.getRoot()));

    }
}

package billionaire.nitin.kumar.gupta.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.leftChild), maxDepth(root.rightChild));
    }

    public static int minDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.min(minDepth(root.leftChild), minDepth(root.rightChild));
    }

    public static boolean isBalanced(Node root) {
        return (maxDepth(root) - minDepth(root) <= 1);
    }

    public Node<T> getRoot() {
        return root;
    }

    public void insert(T data) {
        if (root == null) {
            root = new Node(data, null);
        } else {
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {
        if (node.data.compareTo(data) > 0) {
            if (node.leftChild != null) {
                insert(data, node.leftChild);
            } else {
                node.leftChild = new Node<T>(data, node);
            }
        } else {
            if (node.rightChild != null) {
                insert(data, node.rightChild);
            } else {
                node.rightChild = new Node<T>(data, node);
            }
        }
    }

    public void inOrderTraversal() {
        if (root != null) inOrderTraversal(root);
    }

    //Left-root-right
    private void inOrderTraversal(Node<T> node) {
        if (node != null) {
            if (node.leftChild != null) inOrderTraversal(node.leftChild);
            System.out.print(node + " ->");
            if (node.rightChild != null) inOrderTraversal(node.rightChild);
        }
    }

    public void preOrderTraversal() {
        if (root != null) preOrderTraversal(root);
    }

    //root-left-right
    private void preOrderTraversal(Node<T> node) {
        System.out.print(node + " ->");
        if (node.leftChild != null) preOrderTraversal(node.leftChild);
        if (node.rightChild != null) preOrderTraversal(node.rightChild);
    }

    //left-right-root
    public void postOrderTraversal() {
        if (root != null) postOrderTraversal(root);
    }

    private void postOrderTraversal(Node<T> node) {
        if (node.leftChild != null) postOrderTraversal(node.leftChild);
        if (node.rightChild != null) postOrderTraversal(node.rightChild);
        System.out.print(node + " ->");
    }

    public void delete(T data) {
        if (root != null) delete(data, root);
    }

    private void delete(T data, Node<T> node) {
        if (node == null) return;
        if (node.data.compareTo(data) > 0) {
            //existing node is less than to root node
            delete(data, node.leftChild);
        } else if (node.data.compareTo(data) < 0) {
            //existing node is greater than to root node
            delete(data, node.rightChild);
        } else {
            //date is present in BST
            System.out.println("date is present in BST");

            if (node.leftChild == null && node.rightChild == null) {
                System.out.println("case 1 when left and right children both are null");
                Node<T> parent = node.parentNode;
                if (parent != null && parent.leftChild == node) {
                    System.out.println("when left child is present and same value of node");
                    parent.leftChild = null;
                } else if (parent != null && parent.rightChild == node) {
                    System.out.println("when right child is present and same value of node");
                    parent.rightChild = null;
                } else if (parent == null) {
                    System.out.println("when root node is null");
                    root = null;
                } else {
                }
                //node must be GC
                node = null;
            } else if (node.leftChild != null && node.rightChild == null) {
                System.out.println("case 2 when left child not null and right child null");
                Node<T> perent = node.parentNode;
                if (perent != null && perent.leftChild == node) {
                    System.out.println("node present in left node");
                    perent.leftChild = node.leftChild;
                } else if (perent != null && perent.rightChild == node) {
                    System.out.println("node is present in right node");
                    perent.rightChild = node.leftChild;
                } else if (perent == null) {
                    System.out.println("parents null");
                    root = node.leftChild;
                } else {
                }
                node.leftChild.parentNode = perent;
                //node must be GC
                node = null;
            } else if (node.leftChild == null && node.rightChild != null) {
                System.out.println("case 3 when left child are null and right child are not bull");
                Node<T> parent = node.parentNode;
                if (parent != null && parent.leftChild == null) {
                    System.out.println("node present in left child");
                    parent.leftChild = node.rightChild;
                } else if (parent != null && parent.rightChild == null) {
                    System.out.println("node present in right child");
                    parent.rightChild = node.rightChild;
                } else if (parent == null) {
                    System.out.println("parent node are null");
                    root = node.rightChild;
                } else {
                }
                node.rightChild.parentNode = parent;
                System.out.println("node must be GC");
                node = null;
            } else {
                System.out.println("case 4 when left child are not null and right child are not bull");
                System.out.println("deleting node when both node (left+right)present");
                System.out.println("Now we have a choice either predecessor or successor use  ");
                System.out.println("now I am using Predecessor");
                /*Node<T> predescesor  =getPredecessor(node.leftChild);
                T temp = predescesor.data;
                predescesor.data= node.data;
                node.data=  temp;
                delete(data ,predescesor);*/

                Node<T> successor = getSuccessor(node.rightChild);
                T temp = successor.data;
                successor.data = node.data;
                node.data = temp;
                delete(data, successor);
            }
        }
    }

    public Node<T> getPredecessor(Node<T> node) {
        if (node.rightChild != null) return getPredecessor(node.rightChild);
        return node;
    }

    public Node<T> getSuccessor(Node<T> node) {
        if (node.leftChild != null) return getSuccessor(node.leftChild);
        return node;
    }

    public T getMaxValue() {
        if (root == null) return null;
        return getMaxValue(root);
    }

    public T getMaxValue(Node<T> node) {
        if (node.rightChild != null) return getMaxValue(node.rightChild);
        return node.data;
    }

    public T getMinValue() {
        if (root == null) return null;
        return getMinValue(root);
    }

    public T getMinValue(Node<T> node) {
        if (node.leftChild != null) return getMinValue(node.leftChild);
        return node.data;
    }

    public T findSmallestValue(Node<T> node) {
        return node.leftChild == null ? node.data : findSmallestValue(node.leftChild);
    }

    public T findLargestValue(Node<T> node) {
        return node.rightChild == null ? node.data : findSmallestValue(node.rightChild);
    }

    public boolean searchData(T data) {
        if (root == null) return false;
        return searchData(data, root);
    }

    public boolean searchData(T data, Node<T> node) {
        if (node == null) return false;
        else if (node.data == data) return true;
        return node.data.compareTo(data) > 0 ? searchData(data, node.leftChild) : searchData(data, node.rightChild);
    }

    public int countNode(Node<T> node) {
        if (node == null) return 0;
        else {
            int l = 1;
            l += countNode(node.leftChild);
            l += countNode(node.rightChild);
            return l;
        }
    }

    public void printLeafNodes(Node node) {
        // base case
        if (node == null) {
            return;
        }
        if (node.leftChild == null && node.rightChild == null) {
            System.out.printf("%d ", node.data);
        }
        printLeafNodes(node.leftChild);
        printLeafNodes(node.rightChild);
    }

    public int height(Node node) {
        if (node == null)
            return 0;
        int lheight = height(node.leftChild);
        int rheight = height(node.rightChild);
        /* use the larger one */
        if (lheight > rheight)
            return (lheight + 1);
        else
            return (rheight + 1);
    }

    public Node<T> mirror(Node<T> node) {
        if (node == null)
            return node;

        /* do the subtrees */
        Node left = mirror(node.leftChild);
        Node right = mirror(node.rightChild);

        /* swap the left and right pointers */
        node.leftChild = right;
        node.rightChild = left;

        return node;
    }

    public void levelOrderTraverse(Node node) {
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            Node node1 = nodes.remove();
            System.out.print("  " + node1.data);
            if (node1.leftChild != null) {
                nodes.add(node1.leftChild);
            }
            if (node1.rightChild != null) {
                nodes.add(node1.rightChild);
            }
        }

    }

    // Write Code to Determine if Two Trees are Identical
    /*
     * Given two trees, return true if they are structurally identical
     */
    boolean identicalTrees(Node a, Node b) {
        /* 1. both empty */
        if (a == null && b == null)
            return true;

        /* 2. both non-empty -> compare them */
        if (a != null && b != null)
            return (a.data == b.data && identicalTrees(a.leftChild, b.leftChild) && identicalTrees(a.rightChild, b.rightChild));

        /* 3. one empty, one not -> false */
        return false;
    }

    boolean isFoldable(Node node) {
        boolean res;

        /* base case */
        if (node == null)
            return true;

        /* convert left subtree to its mirror */
        mirror(node.leftChild);

        /*
         * Compare the structures of the right subtree and mirrored left subtree
         */
        res = isStructSame(node.leftChild, node.rightChild);

        /* Get the originial tree back */
        mirror(node.leftChild);

        return res;
    }

    boolean isStructSame(Node a, Node b) {
        if (a == null && b == null)
            return true;
        if (a != null && b != null && isStructSame(a.leftChild, b.leftChild) && isStructSame(a.rightChild, b.rightChild))
            return true;

        return false;
    }

    private static class Node<T extends Comparable<T>> {
        Node<T> leftChild, rightChild, parentNode;
        T data;

        Node(T data, Node<T> parentNode) {
            this.data = data;
            this.parentNode = parentNode;
        }

        @Override
        public String toString() {
            return "{" + data + '}';
        }

    }


}

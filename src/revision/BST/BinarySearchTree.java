package revision.BST;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {


    public Node<T> getMin(Node node) {
        return node.leftChild!=null ? getMin(node.leftChild):node;
    }

    public void printLeafNode(Node<T> node) {
        if(node.leftChild==null && node.rightChild ==null)
            System.out.print(node);
        if(node.leftChild!=null) printLeafNode(node.leftChild);
        if(node.rightChild!=null) printLeafNode(node.rightChild);
    }

    public boolean isNodePresent(T data) {
        if(root==null) {
            return false;
        }else{
            return  isNodePresent(data ,root);
        }
    }

    private boolean isNodePresent(T data, Node<T> node) {
        if(node.data.equals(data)) return true;
        return node.data.compareTo(data) > 0 ? isNodePresent(data, node.leftChild) : isNodePresent(data, node.rightChild);
    }

    public int countNode(Node node) {
        if (node == null) return 0;
        else {
            int l = 1;
            l += countNode(node.leftChild);
            l += countNode(node.rightChild);
            return l;
        }
    }

    public int  height(Node node) {
        if(node==null) {
            return 0;
        }else{
            int l=1 ,r=1;
            int lheight = l+height(node.leftChild);
            int rheight = r+height(node.leftChild);
            return lheight>rheight?lheight:rheight;
        }
    }

    public void levelOrderTraverse(Node<T> node) {
        Queue<Node<T>> nodes = new LinkedList<Node<T>>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            Node<T> node1 = nodes.remove();
            System.out.print("  " + node1);
            if (node1.leftChild != null) {
                nodes.add(node1.leftChild);
            }
            if (node1.rightChild != null) {
                nodes.add(node1.rightChild);
            }
        }
    }

    private static class Node<T extends Comparable<T>> {
        Node leftChild, rightChild, parentNode;
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

    private Node<T> root;

    public Node<T> getRoot() {
        return this.root;
    }

    //Left-root-right
    public void inOrderTraversal(Node<T> node) {
        if (node.leftChild != null) inOrderTraversal(node.leftChild);
        System.out.print(node);
        if (node.rightChild != null) inOrderTraversal(node.rightChild);
    }

    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data, null);
        } else {
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {
        if (node.data.compareTo(data) > 0) {
            if (node.leftChild != null) {
                insert(data, node.leftChild);
            } else {
                node.leftChild = new Node(data, node);
            }
        } else {
            if (node.rightChild != null) {
                insert(data, node.rightChild);
            } else {
                node.rightChild = new Node(data, node);
            }
        }
    }

    public void delete(T data) {
        if (root == null) {
            return;
        }else {
            delete(data, root);
        }
    }

    private void delete(T data, Node<T> node) {
        if(node==null) return;
        else if (node.data.compareTo(data) > 0) {
            delete(data, node.leftChild);
        } else if (node.data.compareTo(data) < 0) {
            delete(data, node.rightChild);
        } else {
            System.out.println("node is present");
            if (node.leftChild == null && node.rightChild == null) {
                Node<T> parent = node.parentNode;
                if (parent != null && parent.leftChild == node) {
                    parent.leftChild = null;
                } else if (parent != null && parent.rightChild == node) {
                    parent.rightChild = null;
                } else if (parent == null) {
                    root = null;
                } else {
                }
                //Node must be GC
                node = null;

            } else if (node.leftChild != null && node.rightChild == null) {
                Node<T> parent = node.parentNode;
                if (parent != null && parent.leftChild == node) {
                    parent.leftChild = node.leftChild;
                } else if (parent != null && parent.rightChild == node) {
                    parent.rightChild = node.leftChild;
                } else if (parent == null) {
                    root = node.leftChild;
                } else {
                }
                node.leftChild.parentNode = parent;
                //need node must be GC
                node = null;

            } else if (node.leftChild == null && node.rightChild != null) {
                Node<T> parent = node.parentNode;
                if (parent != null && parent.leftChild == node) {
                    parent.leftChild = node.rightChild;
                } else if (parent != null && parent.rightChild == node) {
                    parent.rightChild = node.rightChild;
                } else if (parent == null) {
                    root = node.rightChild;
                } else {
                }
                node.rightChild.parentNode = parent;
                //must be GC node
                node = null;
            } else {
                Node<T> predecessor = getPredecessor(node.leftChild);
                T temp = predecessor.data;
                predecessor.data = node.data;
                node.data = temp;
                delete(data, predecessor);
            }
        }
    }

    private Node<T> getPredecessor(Node<T> node) {
        if (node.rightChild != null) return getPredecessor(node.rightChild);
        return node;
    }

    public Node<T> getMax(Node<T> node){
        return node.rightChild !=null ? getMax(node.rightChild): node;
    }
}

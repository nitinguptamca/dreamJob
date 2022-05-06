package billionaire.nitin.kumar.gupta.avlTree;

public class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data, null);
        } else {
            insert(data, root);
        }
    }

    private void insert(int data, Node node) {
        if (node.data > data) {
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
        updateHeight(node);
        settleViolation(node);
    }

    private void settleViolation(Node node) {
        //we have to check up to root level node 0(logN)
        while ((node != null)) {
            updateHeight(node);
            settleViolationHelper(node);
            node = node.parentNode;
        }
    }

    private void settleViolationHelper(Node node) {
        int balance = getBalance(node);
        //left heavy
        if (balance > 1) {
            System.out.println("Left heavy ");
            //left -right heavy
            if (getBalance(node.leftChild) < 0) {
                System.out.println("Left-Right  heavy ");
                leftRotation(node.leftChild);
            }
            //left -left heavy
            System.out.println("Left-left  heavy ");
            rightRotation(node);
        }
        //right heavy
        if (balance < -1) {
            System.out.println("Right heavy ");
            //right-left heavy
            if (getBalance(node.rightChild) > 0) {
                System.out.println("Right-left heavy ");
                rightRotation(node.rightChild);
            }
            //right -right heavy
            System.out.println("Right-Right  heavy ");
            leftRotation(node);
        }
    }

    private void rightRotation(Node node) {
        System.out.println("Rotating right on node" + node);
        //node B parent node is D && D.leftChild =B
        Node tempLeftChild = node.leftChild;
        //Node C
        Node grandChild = tempLeftChild.rightChild;
        //Make the rotation - the new root node will be tne tempLeftChild
        //Node B right child to node D
        tempLeftChild.rightChild = node;
        //Node D left child to C
        node.leftChild = grandChild;
        //Now we have to handle the parents
        if (grandChild != null) {
            grandChild.parentNode = node;
        }
        //We have to handle the parents of the node
        //swap (B and D)
        Node tempParent = node.parentNode;
        node.parentNode = tempLeftChild;
        tempLeftChild.parentNode = tempParent;

        //either parent is left
        if (tempLeftChild.parentNode != null && tempLeftChild.parentNode.leftChild == node) {
            tempLeftChild.parentNode.leftChild = tempLeftChild;
        }
        //or parent is right
        if (tempLeftChild.parentNode != null && tempLeftChild.parentNode.rightChild == node) {
            tempLeftChild.parentNode.rightChild = tempLeftChild;
        }

        //no parent after rotations be because it has become root node
        if (node == root) root = tempLeftChild;
        updateHeight(node);
        updateHeight(tempLeftChild);
    }

    private void leftRotation(Node node) {
        System.out.println("Rotating Left on node" + node);
        //node B parent node is D && B.rightChild =D
        Node tempRightChild = node.rightChild;
        //Node C
        Node grandChild = tempRightChild.leftChild;
        //Make the rotation - the new root node will be tne tempRightChild
        //Node D left child to node B
        tempRightChild.leftChild = node;
        //Node B right  child to C
        node.rightChild = grandChild;
        //Now we have to handle the parents
        if (grandChild != null) {
            grandChild.parentNode = node;
        }
        //We have to handle the parents of the node
        Node tempParent = node.parentNode;
        node.parentNode = tempRightChild;
        tempRightChild.parentNode = tempParent;

        //either parent is left
        if (tempRightChild.parentNode != null && tempRightChild.parentNode.leftChild == node) {
            tempRightChild.parentNode.leftChild = tempRightChild;
        }
        //or parent is right
        if (tempRightChild.parentNode != null && tempRightChild.parentNode.rightChild == node) {
            tempRightChild.parentNode.rightChild = tempRightChild;
        }

        //no parent after rotations be because it has become root node
        if (node == root) root = tempRightChild;
        updateHeight(node);
        updateHeight(tempRightChild);
    }


    public void delete(int data) {
        if (root != null) delete(root, data);
    }

    private void delete(Node node, int data) {
        if (node == null) return;
        else if (node.data > data) {
            delete(node.leftChild, data);
        } else if (node.data < data) {
            delete(node.rightChild, data);
        } else {
            //Node must be leaf node
            if (node.leftChild == null && node.rightChild == null) {
                System.out.println("when left & right child not present");
                Node parent = node.parentNode;
                if (parent != null && parent.leftChild == node) {
                    parent.leftChild = null;
                } else if (parent != null && parent.rightChild == node) {
                    parent.rightChild = null;
                } else if (parent == null) {
                    root = null;
                }
                node = null;
                updateHeight(parent);
                settleViolation(parent);
            }

            //Node have only left child.
            else if (node.leftChild != null && node.rightChild == null) {
                System.out.println("when left Present & right child not present");
                Node parent = node.parentNode;
                if (parent != null && parent.leftChild == node) {
                    parent.leftChild = node.leftChild;
                } else if (parent != null && parent.rightChild == node) {
                    parent.rightChild = node.leftChild;
                } else if (parent == null) {
                    root = null;
                }
                node.leftChild.parentNode = parent;
                node = null;
                updateHeight(parent);
                settleViolation(parent);
            }
            //Node have only right child.
            else if (node.leftChild == null && node.rightChild != null) {
                System.out.println("when left not Present & right child  present");
                Node parent = node.parentNode;
                if (parent != null && parent.leftChild == node) {
                    parent.leftChild = node.rightChild;
                } else if (parent != null && parent.rightChild == node) {
                    parent.rightChild = node.rightChild;
                } else if (parent == null) {
                    root = null;
                }
                node.rightChild.parentNode = parent;
                node = null;
                updateHeight(parent);
                settleViolation(parent);
            }
            //Node have both left and right child
            else {
                System.out.println("when left & right child present");
                Node predecessor = getPredecessor(node.leftChild);
                int temp = predecessor.data;
                predecessor.data = node.data;
                node.data = temp;
                delete(predecessor, data);

            }
        }
    }

    private Node getPredecessor(Node node) {
        if (node.rightChild != null) return getPredecessor(node.rightChild);
        return node;
    }


    public void traversal() {
        if (root != null) traversal(root);
    }

    private void traversal(Node node) {
        if (node.leftChild != null) traversal(node.leftChild);
        System.out.print(" " + node.data);
        if (node.rightChild != null) traversal(node.rightChild);
    }

    public int getHeight(Node node) {
        if (node == null) return -1;
        return node.height;
    }

    public int getBalance(Node node) {
        if (node == null) return 0;
        return getHeight(node.leftChild) - getHeight(node.rightChild);
    }

    public void updateHeight(Node node) {
        node.height = Math.max(getHeight(node.leftChild), getHeight(node.rightChild)) + 1;
    }

    private static class Node {
        Node leftChild, rightChild, parentNode;
        int data;
        int height;

        Node(int data, Node parentNode) {
            this.data = data;
            this.parentNode = parentNode;
        }

        Node(int data) {
            this.data = data;
            this.parentNode = parentNode;
        }

        @Override
        public String toString() {
            return "  " + data;
        }
    }
}

package billionaire.nitin.kumar.gupta.tst;

public class TernarySearchTree {

    private static class Node {
        Node leftChild, middleChild, rightChild;
        char character;
        int value;
        boolean leafNode;

        @Override
        public String toString() {
            return "{" + character + '}';
        }

        Node(char character) {
            this.character = character;
        }
    }

    public Node getRoot() {
        return root;
    }

    private Node root;

    public void put(String key ,int value){
        root = insert(root, key, value, 0);
    }

    private Node insert(Node node, String key, int value, int index) {
        // actual index of the key
        char c = key.charAt(index);
        if(node==null) node =new Node(c);
        if(c < node.character) node.leftChild = insert(node.leftChild ,key ,value,index);
        else if(c> node.character) node.rightChild =insert(node.rightChild ,key,value,index);
        else if(index < key.length() -1) node.middleChild = insert(node.middleChild ,key,value,index+1);
        else{
            node.leafNode=true;
            node.value=value;
        }
        return node;
    }

    // associative array - we get a value based on a key
    public Integer get(String key) {
        Node node = get(root, key, 0);
        // there may be a search miss
        if(node == null) return null;
        return node.value;
    }

    private Node get(Node node, String key, int index) {

        // base case
        if(node == null) return null;

        // we consider the letters in the key one by one
        char c = key.charAt(index);

        if(c < node.character) {
            return get(node.leftChild, key, index);
        } else if(c > node.character) {
            return get(node.rightChild, key, index);
        } else if(index < key.length() - 1) {
            return get(node.middleChild, key, index+1);
        } else {
            // we have considered all the letters
            if(!node.leafNode) return null;
            // we have found the node
            return node;
        }
    }


    public void traverse() {
        if(root!=null)
            traverse(root, "");
    }

    private void traverse(Node node, String s) {

        // left + root + right RECURSIVE MANNER
        // we hit a leaf node
        if (node.middleChild == null || node.value != 0)
            System.out.println(s + node.character + ": " + node.value);

        // recursively to the left
        if(node.leftChild != null)
            traverse(node.leftChild, s);

        // middle child
        if (node.middleChild != null)
            traverse(node.middleChild, s + node.character);

        // right child
        if(node.rightChild != null)
            traverse(node.rightChild, s);
    }

}

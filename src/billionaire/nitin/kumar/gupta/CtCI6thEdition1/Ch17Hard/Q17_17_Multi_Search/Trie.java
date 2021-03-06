package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch17Hard.Q17_17_Multi_Search;

import java.util.ArrayList;

public class Trie {
    private TrieNode root = new TrieNode();

    public ArrayList<Integer> search(String s) {
        return root.search(s);
    }

    public void insertString(String str, int location) {
        root.insertString(str, location);
    }

    public TrieNode getRoot() {
        return root;
    }
}

package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch09ScalabilityandMemoryLimits.Q9_05_Cache;

public class Node {
    public Node prev;
    public Node next;
    public String[] results;
    public String query;

    public Node(String q, String[] res) {
        results = res;
        query = q;
    }
}

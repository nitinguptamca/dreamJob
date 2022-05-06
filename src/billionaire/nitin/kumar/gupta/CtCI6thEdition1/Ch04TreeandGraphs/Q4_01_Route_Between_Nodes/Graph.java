package billionaire.nitin.kumar.gupta.CtCI6thEdition1.Ch04TreeandGraphs.Q4_01_Route_Between_Nodes;

public class Graph {
    public static int MAX_VERTICES = 6;
    public int count;
    private Node vertices[];

    public Graph() {
        vertices = new Node[MAX_VERTICES];
        count = 0;
    }

    public void addNode(Node x) {
        if (count < vertices.length) {
            vertices[count] = x;
            count++;
        } else {
            System.out.print("Graph full");
        }
    }

    public Node[] getNodes() {
        return vertices;
    }
}


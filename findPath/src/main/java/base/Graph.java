package base;

import findPath.AbstractAlgorithmFindPath;
import util.Utils;

import java.util.*;

public abstract class Graph {
    private List<Node> nodes = new ArrayList<>();
    Hashtable<Integer, TreeSet<String>> hashtable;

    public Graph() {
    }

    public Graph(Hashtable<Integer, TreeSet<String>> hashtable) {
        this.hashtable = hashtable;
        loadNodes();
    }

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void loadNodes() {
        for (Integer key : hashtable.keySet()
        ) {
            Node node = new Node(key + "");
            Iterator<String> iterator = hashtable.get(key).iterator();
            while (iterator.hasNext()) {
                node.addNeighbour(iterator.next());
            }
            this.nodes.add(node);
        }
    }

    public void addNode(Node node) {
        if (!nodes.contains(node))
            nodes.add(node);
    }

    public Node getNode(String name) {
        for (Node node :
                nodes) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }

    public abstract int degree(int src);

    public abstract int degreeInside(int src);

    public abstract int degreeOutside(int src);

    public Object[] findPath(AbstractAlgorithmFindPath algorithm) {
        algorithm.setGraph(this);
        Object[] path=  algorithm.findPath();
        return path;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Hashtable<Integer, TreeSet<String>> getHashtable() {
        return hashtable;
    }

    public void setHashtable(Hashtable<Integer, TreeSet<String>> hashtable) {
        this.hashtable = hashtable;
    }

    @Override
    public String toString() {
        return nodes.toString();
    }


}

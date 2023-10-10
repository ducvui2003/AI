package code.base;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Node parent = null;
    private String name;
    private List<Node> neighbours = new ArrayList<>();
    private int value;
    private boolean visited = false;
    //N Hau

    public Node(String name) {
        this.name = name;
    }

    public Node(int n) {
        this.value = n;
    }


    public Node(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }

    public void addNeighbour(Node node) {
        this.neighbours.add(node);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Parent Node: " + parent + "Visited:" + visited + "Name node: " + name + "\tChild Nodes: " + neighbours.toString() + "\n";
    }


}

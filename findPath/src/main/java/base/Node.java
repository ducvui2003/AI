package base;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String parent = null;
    private String name;
    private List<String> neighbours = new ArrayList<>();
    private int value;
    private boolean visited = false;

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void addNeighbour(String vertex) {
        neighbours.add(vertex);
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<String> neighbours) {
        this.neighbours = neighbours;
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
        return "Parent Node: " + parent + "Visited:" + visited + "Name node: " + name + "\tChild Nodes: " + neighbours.toString()+"\n";
    }
}

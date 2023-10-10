package nHau;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int n;
    private List<Integer> state;
    private List<Node> neighbours;

    public Node(int n) {
        this.n = n;
        this.state = new ArrayList<>();
        this.neighbours = new ArrayList<>();
    }

    public Node(int n, List<Integer> state) {
        this.n = n;
        this.state = state;
        this.neighbours = new ArrayList<>();
    }

    public List<Integer> place(int x) {
        List<Integer> stateClone = new ArrayList<>();
        state.forEach(node -> stateClone.add(node));
        stateClone.add(x);
        if (isValid(stateClone)) {
            return stateClone;
        } else {
            return null;
        }
    }

    public List<Node> getNeighbours() {
        if (state.size() == 0) {
            return null;
        }
        for (int i = 0; i < state.size(); i++) {
            if (place(i) != null) {
                Node node = new Node(i, state);
                this.addNeighbour(node);
            }
        }
        return this.neighbours;
    }

    public void addNeighbour(Node node) {
        this.neighbours.add(node);
    }

    public boolean isValid(List<Integer> state) {
        if (state.size() == 1) {
            return true;
        }
        if (state.size() > 1) {
            int numberCompare = state.get(state.size() - 1);
            for (int i = 0; i < state.size() - 1; i++) {
                if (numberCompare - state.get(i) < 2) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public List<Integer> getState() {
        return state;
    }

    public void setState(List<Integer> state) {
        this.state = state;
    }

    public void setNeighbours(List<Node> neighbours) {
        this.neighbours = neighbours;
    }
}
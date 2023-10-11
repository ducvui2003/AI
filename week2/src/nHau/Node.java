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
        //Clone
        List<Integer> stateClone = new ArrayList<>(state);
        stateClone.add(x);
        if (isValid(stateClone)) {
            return stateClone;
        } else {
            return null;
        }
    }

    public List<Node> getNeighbours() {
        if (this.state.size() == this.n) {
            return null;
        }
        for (int i = 0; i < this.n; i++) {
            List<Integer> newState = place(i);
            if (newState != null) {
                Node node = new Node(n, newState);
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

        int before = state.get(state.size() - 1);
        int after = state.get(state.size() - 2);
        boolean equaltion = before - after >= 2 || before - after <= -2;
        if (state.size() == 2) {
            return equaltion;
        }
        if (equaltion) {
            for (int i = 0; i < state.size() - 1; i++) {
                if (state.get(i) == before) {
                    return false;
                }
            }
            return true;
        }
        return false;
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

    @Override
    public String toString() {
        return "Node{" +
                "n=" + n +
                ", state=" + state +
                ", neighbours=" + neighbours +
                '}';
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Node {
    private int n;
    private List<Integer> state;

    public Node(int n) {
        this.n = n;
        this.state = new ArrayList<>();
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            this.state.add(rd.nextInt(n));
        }
    }

    public Node(int n, List<Integer> state) {
        this.n = n;
        this.state = state;
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

    public Node clone() {
        int n = this.n;
        List<Integer> state = new ArrayList<>();
        state.addAll(this.state);
        return new Node(n, state);
    }

    @Override
    public String toString() {
        return "Node{" +
                "n=" + n +
                ", state=" + state +
                '}';
    }
}

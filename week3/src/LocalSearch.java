import java.util.*;

public class LocalSearch {
    public int checkHorizontal(Node node) {
        int conflict = 0;
        int sizeState = node.getState().size();
        if (sizeState == 0 || sizeState == 1) return conflict;
        Set<Integer> fillState = new HashSet<>(node.getState());
        conflict = sizeState - fillState.size();
        return conflict;
    }

    public int checkDiagonal(Node node) {
        int conflict = 0;
        int sizeState = node.getState().size();
        if (sizeState == 0 || sizeState == 1) return conflict;
        List<Integer> state = node.getState();
        int last = state.get(sizeState - 1);
        for (int i = 0; i < sizeState - 1; i++) {
            if (Math.abs(state.get(i) - last) == Math.abs(i - state.size() - 1)) {
                conflict++;
            }
        }
        return conflict;
    }

    public int heuristic(Node node) {
        return checkHorizontal(node) + checkDiagonal(node);
    }

    public int tryMovingOneQueen(Node node, int x, int y) {
        node.getState().remove(y);
        node.getState().add(y, x);
        return heuristic(node);
    }

    public SortedMap<Integer, Node> generateNeighbours(Node node) {
        SortedMap<Integer, Node> sortHeuristic = new TreeMap<>();
        for (int col = 0; col < node.getN(); col++) {
            for (int row = 0; row < node.getN(); row++) {
                if (node.getState().get(col) == row) {
                    continue;
                }
                Node nodeClone = node.clone();
                int conflict = tryMovingOneQueen(nodeClone, row, col);
//                System.out.println("node "+nodeClone);
                sortHeuristic.put(conflict, nodeClone);
            }
        }
        return sortHeuristic;
    }

    public void run() {
        Node initial = new Node(4);
        if (heuristic(initial) == 0) {
            System.out.println(initial.getState());
            return;
        }
        System.out.println("Initial state is: " + initial.getState());
        Node node = initial;
        SortedMap<Integer, Node> neighbours = generateNeighbours(node);
        Integer bestHeuristic = neighbours.firstKey();
        while (bestHeuristic < heuristic(node)) {
            node = neighbours.get(bestHeuristic);
//            System.out.println(node.getN());
            neighbours = generateNeighbours(node);
            bestHeuristic = neighbours.firstKey();
        }
        if (heuristic(node) == 0) {
            System.out.println("Goal is: " + node
                    .getState());
        } else {
            System.out.println("Cannot find goal state! Best state is: " + node.getState());
        }
    }
}

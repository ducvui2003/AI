package nHau;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFS {
    public Node dfsUsingStack(Node node, int n) {
        Stack<Node> stack = new Stack<>();
        if (node.getState().size() == n) {
            return node;
        }
        stack.add(node);
        while (!stack.isEmpty()) {
            Node q = stack.pop();
            List<Node> adjective = q.getNeighbours();
            if (adjective == null) {
                return q;
            }
            for (int i = 0; i < adjective.size(); i++) {
                stack.add(adjective.get(i));
            }
        }
        return null;
    }
}

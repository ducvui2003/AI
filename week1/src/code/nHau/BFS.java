package code.nHau;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public Node bfsUsingQueue(Node node, int n) {
        Queue<Node> queue = new LinkedList<>();
        if (node.getState().size() == n) {
            return node;
        }
        queue.add(node);
        while (!queue.isEmpty()) {
            Node q = queue.poll();
            for (int i =0; i< n; i++){
                q.place(i);
            }
            List<Node> adjective = q.getNeighbours();
            for (int i = 0; i < adjective.size(); i++) {
                Node currentNode = adjective.get(i);
                if (currentNode.getState().size() == n) {
                    return currentNode;
                }
            }
        }
        return null;
    }
}

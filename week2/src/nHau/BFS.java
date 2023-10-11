package nHau;

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
            List<Node> adjective = q.getNeighbours();
            if (adjective == null) {
                return q;
            }
            for (int i = 0; i < adjective.size(); i++) {
                queue.add(adjective.get(i));
            }
//            List<Node> adjective = q.getNeighbours();
//            for (int i = 0; i < n; i++) {
//                Node currentNode = adjective.get(i);
//                currentNode.place(i);
//                if (currentNode.getState().size() == n) {
//                    return currentNode;
//                }else{
//                    queue.add(currentNode);
//                }
//            }

        }
        return null;
    }
}

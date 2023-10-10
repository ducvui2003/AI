package findPath;

import base.Graph;
import base.Node;
import util.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS extends AbstractAlgorithmFindPath {

    public BFS(Graph graph, String start, String end) {
        super(graph, start, end);
    }

    public BFS(String start, String end) {
        super(start, end);
    }

    @Override
    public Object[] findPath() {
        ArrayList<Node> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (start == end) {
            result.add(start);
            return result.toArray();
        }
        start.setVisited(true);
        queue.add(start);
        while (!queue.isEmpty()) {
            Node q = queue.poll();
            List<Node> adjective = q.getNeighbours();
            for (int i = 0; i < adjective.size(); i++) {
                Node currentNode = adjective.get(i);
                if (!currentNode.isVisited()) {
                    currentNode.setParent(q);
                    if (currentNode == end) {
                        return Utils.getINSTANCE().path(adjective.get(i), start.getName());
                    } else {
                        currentNode.setVisited(true);
                        queue.add(currentNode);
                    }
                }
            }
        }
        return null;
    }


}




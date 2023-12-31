package code.findPath;


import code.base.Graph;
import code.base.Node;
import code.common.Utils;

import java.util.*;

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




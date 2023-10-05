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
        ArrayList<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        if (start.equals(end)) {
            result.add(start);
            return result.toArray();
        }
        queue.add(start);
        graph.getNode(start).setVisited(true);
        while (!queue.isEmpty()) {
            String q = queue.poll();
            List<String> adjective = graph.getNode(q).getNeighbours();
            for (int i = 0; i < adjective.size(); i++) {
                Node currentNode = graph.getNode(adjective.get(i));
                if (!currentNode.isVisited()) {
                    currentNode.setParent(q);
                    if (currentNode.getName().equals(end)) {
                        return Utils.getINSTANCE().path(graph.getNode(adjective.get(i)), start, graph);
                    } else {
                        currentNode.setVisited(true);
                        queue.add(currentNode.getName());
                    }
                }
            }
        }
        return null;
    }


}




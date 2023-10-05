package findPath;

import base.Graph;
import base.Node;
import util.Utils;

import java.util.*;

public class DFS extends AbstractAlgorithmFindPath {

    public DFS(Graph graph, String start, String end) {
        super(graph, start, end);
    }

    public DFS(String start, String end) {
        super(start, end);
    }

    @Override
    public Object[] findPath() {
        ArrayList<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        if (start.equals(end)) {
            result.add(start);
            return result.toArray();
        }
        stack.add(start);
        graph.getNode(start).setVisited(true);
        while (!stack.isEmpty()) {
            String q = stack.pop();
            List<String> adjective = graph.getNode(q).getNeighbours();
            for (int i = adjective.size() - 1; i >= 0; i--) {
                Node currentNode = graph.getNode(adjective.get(i));
                if (!currentNode.isVisited()) {
                    currentNode.setParent(q);
                    if (adjective.get(i).equals(end)) {
                        return Utils.getINSTANCE().path(graph.getNode(adjective.get(i)), start, graph);
                    } else {
                        graph.getNode(adjective.get(i)).setVisited(true);
                        stack.add(adjective.get(i));
                    }
                }
            }
        }
        return null;
    }


}

package code.findPath;


import code.base.Graph;
import code.base.Node;
import code.common.Utils;

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
        ArrayList<Node> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (start == end) {
            result.add(start);
            return result.toArray();
        }
        start.setVisited(true);
        stack.add(start);
        while (!stack.isEmpty()) {
            Node q = stack.pop();
            List<Node> adjective = q.getNeighbours();
            for (int i = adjective.size() - 1; i >= 0; i--) {
                Node currentNode = adjective.get(i);
                if (!currentNode.isVisited()) {
                    currentNode.setParent(q);
                    if (currentNode == end) {
                        return Utils.getINSTANCE().path(adjective.get(i), start.getName());
                    } else {
                        currentNode.setVisited(true);
                        stack.add(adjective.get(i));
                    }
                }
            }
        }
        return null;
    }


}

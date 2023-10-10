package findPath;

import base.Graph;
import base.Node;

public abstract class AbstractAlgorithmFindPath {
    protected Graph graph;
    protected Node start;
    protected Node end;

    public AbstractAlgorithmFindPath(Graph graph, String start, String end) {
        this.graph = graph;
        this.start = graph.getNode(start);
        this.end = graph.getNode(end);
    }

    public AbstractAlgorithmFindPath(String start, String end) {
        this.start = graph.getNode(start);
        this.end = graph.getNode(end);
    }

    public abstract Object[] findPath();

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }
}

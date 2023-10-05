package findPath;

import base.Graph;
import base.Node;

public abstract class AbstractAlgorithmFindPath {
    protected Graph graph;
    protected String start;
    protected String end;

    public AbstractAlgorithmFindPath(Graph graph, String start, String end) {
        this.graph = graph;
        this.start = start;
        this.end = end;
    }

    public AbstractAlgorithmFindPath(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public abstract Object[] findPath();

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

}

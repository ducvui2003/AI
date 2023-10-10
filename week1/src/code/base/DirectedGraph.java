package code.base;

import java.util.Hashtable;
import java.util.TreeSet;

public class DirectedGraph extends Graph {

    public DirectedGraph() {

    }

    public DirectedGraph(Hashtable<Integer, TreeSet<String>> hashtable) {
        super(hashtable);
    }

    @Override
    public int degree(int src) {
        return 0;
    }

    @Override
    public int degreeInside(int src) {
        return 0;
    }

    @Override
    public int degreeOutside(int srcs) {
        return 0;
    }

}

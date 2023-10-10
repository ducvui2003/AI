package base;

import java.util.Hashtable;
import java.util.TreeSet;

public class UndirectedGraph extends Graph{
    public UndirectedGraph() {
    }

    public UndirectedGraph(Hashtable<Integer, TreeSet<String>> hashtable) {
        super(hashtable);
    }

    @Override
    public int degree(int vertex) {
        if (vertex <= hashtable.size() && vertex >= 0) {
            return hashtable.get(vertex).size();
        } else {
            throw new RuntimeException("Vertex is not exist in hashtable");
        }

    }

    @Override
    public int degreeInside(int vertex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int degreeOutside(int vertex) {
        throw new UnsupportedOperationException();
    }


}

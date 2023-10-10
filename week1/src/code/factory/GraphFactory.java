package code.factory;

;
import code.base.DirectedGraph;
import code.base.Graph;
import code.base.UndirectedGraph;
import code.common.Utils;

import java.util.Hashtable;

public class GraphFactory {
    private static GraphFactory INSTANCE = null;

    private GraphFactory() {
    }

    public static GraphFactory getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new GraphFactory();
        }
        return INSTANCE;
    }

    public Graph makeGraph(String filePath) {
        Hashtable hashtable = Utils.getINSTANCE().readFile(filePath);
        if (Utils.getINSTANCE().checkTypeGraph(hashtable) == true) {
            return new UndirectedGraph(hashtable);
        } else {
            return new DirectedGraph(hashtable);
        }
    }
}

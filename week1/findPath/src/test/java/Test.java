import base.DirectedGraph;
import base.Graph;
import factory.GraphFactory;
import findPath.AbstractAlgorithmFindPath;
import findPath.BFS;
import findPath.DFS;
import util.Utils;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        Graph graph = GraphFactory.getINSTANCE().makeGraph("src/test/graph/graph.txt");
//        System.out.println(Utils.getINSTANCE().checkTypeGraph(graph.getHashtable()));
//        System.out.println(Utils.getINSTANCE().printHashTable(graph.getHashtable()));
//        System.out.println(graph);

        Graph graphPath = GraphFactory.getINSTANCE().makeGraph("D:\\University\\Year 3\\AI\\code\\findPath\\src\\test\\graph\\path.txt");
//        System.out.println(Utils.getINSTANCE().checkTypeGraph(graphPath.getHashtable()));
//        System.out.println(Utils.getINSTANCE().printHashTable(graphPath.getHashtable()));

//        System.out.println(Arrays.toString(new BFS(graphPath, "8", "6").findPath()));
//        Utils.getINSTANCE().resetParentNode(graphPath);
//        Utils.getINSTANCE().resetVisitedNode(graphPath);
//        System.out.println(Arrays.toString(new DFS(graphPath, "8", "6").findPath()));
//        Utils.getINSTANCE().resetParentNode(graphPath);
//        Utils.getINSTANCE().resetVisitedNode(graphPath);

        System.out.println("BFS: " + Arrays.toString(graphPath.findPath(new BFS(graphPath, "8", "6"))));
        System.out.println("DFS: " + Arrays.toString(graphPath.findPath(new DFS(graphPath, "8", "6"))));
    }
}

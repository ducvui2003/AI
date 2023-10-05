package util;

import base.Graph;
import base.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Utils {
    private static Utils INSTANCE;

    private Utils() {

    }

    public static Utils getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Utils();
        }
        return INSTANCE;
    }

    public Hashtable<Integer, TreeSet<String>> readFile(String filePath) {
        String line = null;
        Hashtable<Integer, TreeSet<String>> hashTable = new Hashtable<>();
        Graph graph = null;
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            try {
                line = bufferedReader.readLine();
                int vertexs = Integer.parseInt(line.trim());
                for (int i = 0; i < vertexs; i++) {
                    hashTable.put(i, new TreeSet<>());
                }
            } catch (Exception e) {
                throw new RuntimeException("Vertex is null");
            }
            try {
                int numLine = 0;
                line = bufferedReader.readLine();
                while (line != null) {
                    String[] rowMatrix = line.split("   ");
                    for (int i = 0; i < rowMatrix.length; i++) {
                        if (Integer.parseInt(rowMatrix[i]) > 0) {
                            hashTable.get(numLine).add(i + "");
                        }
                    }
                    numLine++;
                    line = bufferedReader.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashTable;
    }

    public boolean checkTypeGraph(Hashtable<Integer, TreeSet<String>> hashTable) {
//true is undirected
//false is directed
        boolean result = false;
        for (Integer key :
                hashTable.keySet()) {
            Object[] rowMatrix = hashTable.get(key).toArray();
            for (int i = 0; i < rowMatrix.length; i++) {
                if (!hashTable.get(i).contains(rowMatrix[i] + "")) {
                    return false;
                }
            }
        }
        return true;
    }

    public <K, V> String printHashTable(Hashtable<K, TreeSet<V>> hashtable) {
        StringBuilder stringBuilder = new StringBuilder();
        for (K key : hashtable.keySet()) {
            stringBuilder.append(key + " [");
            for (V value : hashtable.get(key)
            ) {
                stringBuilder.append(value + "\t");
            }
            stringBuilder.append("]\n");
        }
        return "Hash Table: \n" + stringBuilder.toString();
    }

    public Object[] path(Node node, String start, Graph graph) {
        LinkedList linkedList = new LinkedList();
        while (!node.getName().equals(start)) {
            linkedList.addFirst(node.getName());
            node = graph.getNode(node.getParent());
        }
        linkedList.addFirst(start);
        resetVisitedNode(graph);
        resetParentNode(graph);
        return linkedList.toArray();
    }

    public void resetParentNode(Graph graph) {
        for (Node node : graph.getNodes()) {
            node.setParent(null);
        }
    }

    public void resetVisitedNode(Graph graph) {
        for (Node node : graph.getNodes()) {
            node.setVisited(false);
        }
    }
}

package nHau;


import java.util.ArrayList;
import java.util.List;

public class Queen {
    private int n ;
    private Node goal;

    public Queen(int n) {
        this.n = n;
    }

    public void dfs() {
        DFS dfs = new DFS();
        this.goal = dfs.dfsUsingStack(new Node(n), n);
    }

    public void bfs() {
        BFS dfs = new BFS();
        this.goal = dfs.bfsUsingQueue(new Node(n), n);
        System.out.println(goal);
    }

    public static void main(String[] args) {
        Queen q = new Queen(8);
        q.bfs();
//        q.dfs();
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        List<Integer> list2 = new ArrayList<>(list);
//        list.remove((Integer) 1);
//        System.out.println(list);
//        System.out.println(list2);
    }
}

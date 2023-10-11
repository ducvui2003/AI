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
        System.out.println(goal);
    }

    public void bfs() {
        BFS dfs = new BFS();
        this.goal = dfs.bfsUsingQueue(new Node(n), n);
        System.out.println(goal);
    }

    public static void main(String[] args) {
        Queen q = new Queen(8);
        System.out.println("BFS: ");
        q.bfs();
        System.out.println("DFS: ");
        q.dfs();
    }
}

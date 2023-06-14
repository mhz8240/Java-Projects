package com.michael.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private int v;
    private ArrayList<Integer>[] adj;
    public Graph(int v) {
        this.v = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void bfs(int s) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
//        System.out.println("Added " + s);
        while (!queue.isEmpty()) {
            int n = queue.poll();
            System.out.print(n + " ");
//            System.out.println("Removed " + n);
            for (int i : adj[n]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
//                    System.out.println("Added " + i);
                }

            }
        }
        System.out.println();
    }

    public void dfs(int s) {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        visited[s] = true;
        stack.add(s);
//        System.out.println("Added " + s);
        while(!stack.isEmpty()) {
            int n = stack.pop();
            System.out.print(n + " ");
            for (int i : adj[n]) {
                if (!visited[i]) {
                    visited[i] = true;
                    stack.add(i);
//                    System.out.println("Added " + i);
                }

            }
        }
    }


}

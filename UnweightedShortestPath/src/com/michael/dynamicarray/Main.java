package com.michael.dynamicarray;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	    // read graph config
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        int nodes = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        Set<String> setOfNodes = new HashSet<>();
        //build a graph
        Graph graph = new Graph(nodes, edges);
        HashMap<String, Integer> dist = new HashMap<>();
        HashMap<String, String> path = new HashMap<>();
        for (int i = 0; i < edges; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String v = st.nextToken();
            String w = st.nextToken();
            setOfNodes.add(v);
            setOfNodes.add(w);
            if (!graph.adj.keySet().contains(v)) {
                graph.adj.put(v, new ArrayList<String>());
            }
            graph.adj.get(v).add(w);
        }
        for (String s : setOfNodes) {
            dist.put(s, Integer.MAX_VALUE);
            path.put(s, "");
        }
        //shortest path

        Queue<String> queue = new LinkedList<>();
        dist.put("a", 0);
        queue.add("a");

        while (!queue.isEmpty()) {
            String v = queue.poll();
            if (graph.adj.get(v) != null) {
                for (String s : graph.adj.get(v)) {
                    if (dist.containsKey(s) && dist.get(s) == Integer.MAX_VALUE) {
                        queue.add(s);
                        dist.put(s, dist.get(v) + 1);
                        path.put(s,v);
                    }
                }
            }


        }
        for (String s : path.values()) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (int i : dist.values()) {
            System.out.print(i + " ");
        }
    }
}

class Graph {
    int nodes;
    int edges;
    HashMap<String, ArrayList<String>> adj = new HashMap<>();

    public Graph(int nodes, int edges) {
        this.nodes = nodes;
        this.edges = edges;
//        adj = new ArrayList[nodes];
    }




}
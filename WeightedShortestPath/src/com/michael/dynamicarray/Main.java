package com.michael.dynamicarray;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
        int nodes = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());
        HashMap<String, ArrayList<Edge>> adj = new HashMap<>();
        Set<MyNode> vertices = new HashSet<>();
        for (int i = 0; i < edges; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            MyNode from = new MyNode(st.nextToken());
            MyNode to = new MyNode(st.nextToken());
            vertices.add(from);
            vertices.add(to);
            int weight = Integer.parseInt(st.nextToken());
            Edge edge = new Edge(from, to, weight);
            if (!adj.keySet().contains(from.data)) {
                adj.put(from.data, new ArrayList<Edge>());
            }
            adj.get(from.data).add(edge);
        }
        HashMap<String, Integer> dist = new HashMap<>();
        HashMap<String, String> path = new HashMap<>();
        HashMap<String, Boolean> collected = new HashMap<>();
        for (MyNode node : vertices) {
            dist.put(node.data, Integer.MAX_VALUE);
            path.put(node.data, "N/A");
            collected.put(node.data, false);
        }

        PriorityQueue<MyNode> pq = new PriorityQueue<>();
        pq.add(new MyNode("A", 0));
        dist.put("A", 0);
        while (true) {
            MyNode myNode = pq.poll();
            if (collected.get("E")) {
                break;
            }
            if (adj.get(myNode.data) != null) {
                for (Edge edge : adj.get(myNode.data)) {
                    MyNode node = edge.to;
                    int weight = edge.weight + myNode.dist;
                    if (dist.get(node.data) == Integer.MAX_VALUE) {
                        pq.add(new MyNode(node.data, weight));
                        dist.put(node.data, weight);
                        path.put(node.data, myNode.data);
                    }
                    else if (weight < dist.get(node.data)) {
                        dist.put(node.data, weight);
                        pq.remove(node);
                        pq.add(new MyNode(node.data, weight));
                        path.put(node.data, myNode.data);
                    }
                }
            }

            collected.put(myNode.data, true);
        }
        for (int i : dist.values()) {
            System.out.println(i);
        }
        System.out.println();
        for (String s : path.values()) {
            System.out.println(s);
        }
    }
}

class Edge {
    MyNode from;
    MyNode to;
    int weight;

    public Edge(MyNode from, MyNode to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", weight=" + weight +
                '}';
    }
}

class MyNode implements Comparable<MyNode> {
    String data;
    int dist;

    public MyNode(String data) {
        this.data = data;
    }

    public MyNode(String data, int dist) {
        this.data = data;
        this.dist = dist;
    }
    @Override
    public int compareTo(MyNode o) {
        return this.dist - o.dist;
    }
}

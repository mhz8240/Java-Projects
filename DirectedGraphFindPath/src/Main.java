import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Edge> edges = new ArrayList<>();
        edges.add(Edge.of(0,3));
        edges.add(Edge.of(3,5));
        edges.add(Edge.of(3,4));
        edges.add(Edge.of(4,3));
        edges.add(Edge.of(1,4));
        edges.add(Edge.of(5,6));
        edges.add(Edge.of(4,6));
        edges.add(Edge.of(2,7));
        edges.add(Edge.of(1,2));
        edges.add(Edge.of(1,0));
        edges.add(Edge.of(6,7));
        int n = 8;
        Graph graph = new Graph(edges, n);
        int src = 0;
        int dest = 7;
        boolean[] discovered = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        if (isConnected(graph, src, dest, discovered, stack)) {
            System.out.println("A path exists from vertex " + src + " to vertex " + dest);
            System.out.println("The path is " + stack);
        }
        else {
            System.out.println("No path exists from vertex " + src + " to vertex " + dest);
        }
//        if (isConnected(graph, src, dest, discovered)) {
//            System.out.println("A path exists from vertex " + src + " to vertex " + dest);
//        }
//        else {
//            System.out.println("No path exists from vertex " + src + " to vertex " + dest);
//        }
    }

    public static boolean isConnected(Graph graph, int src, int dest, boolean[] discovered) {
        Queue<Integer> queue = new ArrayDeque<>();
        discovered[src] = true;
        queue.add(src);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (v == dest) {
                return true;
            }
            for (int n : graph.adjList.get(v)) {
                if (!discovered[n]) {
                    discovered[n] = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }
    public static boolean isConnected(Graph graph, int src, int dest, boolean[] discovered, Stack<Integer> path) {
        discovered[src] = true;
        path.add(src);
        if (src == dest) {
            return true;
        }
        for (int i : graph.adjList.get(src)) {
            if (!discovered[i]) {
                if (isConnected(graph, i, dest, discovered, path)) {
                    return true;
                }
            }
        }
        path.pop();
        return false;

    }
}

class Edge {
    public final int source;
    public final int dest;

    private Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }

    public static Edge of(int source, int dest) {
        return new Edge(source, dest);
    }
}

class Graph {
    List<List<Integer>> adjList = null;

    public Graph(List<Edge> edges, int n) {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge.dest);
        }
    }
}
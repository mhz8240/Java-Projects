import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main{
    static int n;
    static int m;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        visited = new boolean[n];
        dist = new int[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken()) - 1;
            int b = Integer.parseInt(st1.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(i + ": " + adj[i]);
        }
        dfs(0);
        bfs(0);
        System.out.println("");
        //
        br.close();
        pw.close();


    }

    public static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i : adj[node]) {
            if (!visited[i]) {
                dfs(i);

            }
        }

    }

    public static void bfs(int node) {
        System.out.println("");
        System.out.print("BFS: ");
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<Integer>();
        dist[node] = 0;
        queue.add(node);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            System.out.print(i + " ");
            for (int j : adj[i]) {
                if (dist[j] == -1) {
                    dist[j] = dist[i] + 1;
                    queue.add(j);
                }
            }
        }
        System.out.println();
        System.out.println("Distance: ");
        for (int i : dist) {
            System.out.print(i + " ");
        }
    }
}

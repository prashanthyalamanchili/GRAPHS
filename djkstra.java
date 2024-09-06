package graphs;
import java.util.*;

public class djkstra {
    public static void dijkstra(int[][] graph, int src) {
        int V = graph.length;  
        int[] dist = new int[V]; 
        boolean[] visited = new boolean[V];  

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; 
        for (int i = 0; i < V - 1; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;
            for (int v = 0; v < V; v++) {
                // Update dist[v] if it's not visited, there's an edge from u to v, 
                // and the total weight of the path from src to v through u is smaller
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        printSolution(dist, V);
    }
    private static int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < dist.length; v++) {
            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    private static void printSolution(int[] dist, int V) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 0, 0, 0, 0},
            {10, 0, 5, 0, 0, 0},
            {0, 5, 0, 20, 1, 0},
            {0, 0, 20, 0, 2, 3},
            {0, 0, 1, 2, 0, 6},
            {0, 0, 0, 3, 6, 0}
        };
        dijkstra(graph, 0);
    }
}


package prims;

import java.util.*;

public class prims {
    
    public static int primMST(int[][] graph, int V) {
              int[] minEdge = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[0] = 0;
        int totalWeight = 0;
        // Loop through all vertices
        for (int i = 0; i < V; i++) {
            // Find the vertex with the smallest edge weight that is not yet in the MST
            int u = -1;
            for (int j = 0; j < V; j++) {
                if (!visited[j] && (u == -1 || minEdge[j] < minEdge[u])) {
                    u = j;
                }
            }

            // Mark the chosen vertex as visited (added to MST)
            visited[u] = true;
            totalWeight += minEdge[u];

            // Update the minimum edge weights for the adjacent vertices of u
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v] && graph[u][v] < minEdge[v]) {
                    minEdge[v] = graph[u][v];
                }
            }
        }

        return totalWeight; // Return the total weight of the MST
    }

    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int V = 5;
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        // Run Prim's Algorithm and print the total weight of the MST
        int totalWeight = primMST(graph, V);
        System.out.println("Total weight of MST: " + totalWeight);
    }
}

package dfs;

import java.util.*;

public class dfss {

    static class Graph {
        private int vertices;
        private List<List<Integer>> adj;

        public Graph(int vertices) {
            this.vertices = vertices;
            adj = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adj.add(new ArrayList<>());
            }
        }

        public void addEdge(int v, int w) {
            adj.get(v).add(w);
        }

        public void dfs(int startVertex) {
            boolean[] visited = new boolean[vertices];
            dfsUtil(startVertex, visited);
        }

        private void dfsUtil(int vertex, boolean[] visited) {
            visited[vertex] = true;
            System.out.print(vertex + " ");

            for (int neighbor : adj.get(vertex)) {
                if (!visited[neighbor]) {
                    dfsUtil(neighbor, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Depth First Traversal starting from vertex 2:");
        graph.dfs(2);
    }
}

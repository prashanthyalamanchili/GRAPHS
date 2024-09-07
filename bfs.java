package bfss;
import java.util.*;
public class bfs{
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
        public void bfs(int startVertex) {
            boolean[] visited = new boolean[vertices]; 
            Queue<Integer> queue = new LinkedList<>(); 
            visited[startVertex] = true;
            queue.add(startVertex);
            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                System.out.print(vertex + " ");
                for (int neighbor : adj.get(vertex)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor); 
                    }
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
        System.out.println("Breadth First Traversal starting from vertex 2:");
        graph.bfs(2);
    }
}

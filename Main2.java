package DDA;

import java.util.*;

public class Main2 {
    public static void bellmanFord(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE) {
                        int newDistance = dist[u] + graph[u][v];
                        if (newDistance < dist[v]) {
                            dist[v] = newDistance;
                        }
                    }
                }
            }
        }
        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE) {
                    int newDistance = dist[u] + graph[u][v];
                    if (newDistance < dist[v]) {
                        System.out.println("Graph contains negative-weight cycles");
                        return;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Shortest distance from " + source + " to " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        bellmanFord(graph, 0);
    }
}

package DDA;

import java.util.*;

public class Main {
    public static void dijkstra(int[][] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getDistance));
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.getNode();

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0) {
                    int newDistance = dist[u] + graph[u][v];
                    if (newDistance < dist[v]) {
                        dist[v] = newDistance;
                        pq.add(new Node(v, newDistance));
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

        dijkstra(graph, 0);
    }

    static class Node {
        private final int node;
        private final int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public int getNode() {
            return node;
        }

        public int getDistance() {
            return distance;
        }
    }
}

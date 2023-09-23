package ctci.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Graph {
    private Map<Integer, LinkedList<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        if (!adjacencyList.containsKey(source)) {
            adjacencyList.put(source, new LinkedList<>());
        }
        adjacencyList.get(source).add(destination);
    }

    public boolean hasRouteBFS(int source, int destination) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjacencyList.size() + 3];

        queue.add(source);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            visited[current] = true;

            if (current == destination) {
                return true;
            }

            LinkedList<Integer> neighbours = adjacencyList.get(current);
            if (neighbours != null) {
                for (int neighbour : neighbours) {
                    if (!visited[neighbour]) {
                        queue.add(neighbour);
                    }
                }
            }
        }
        return false;
    }
}

public class RouteBetweenNodes {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        g.addEdge(2, 1);
        g.addEdge(4, 3);
        g.addEdge(4, 6);
        g.addEdge(5, 4);
        g.addEdge(6, 2);

        System.out.println(g.hasRouteBFS(6, 4));
        System.out.println(g.hasRouteBFS(5, 2));
        System.out.println(g.hasRouteBFS(3, 2));
    }
}

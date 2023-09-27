package ctci.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BuildOrder {
    public static void main(String[] args) {
        String[][] dependencies = {{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
        Graph<String> graph = BuildGraph(dependencies);
        System.out.println(buildOrder(graph));
    }

    static Graph<String> BuildGraph(String[][] dependencies) {
        Graph<String> g = new Graph<>();
        for (String[] dep : dependencies) {
            String first = dep[0];
            String second = dep[1];
            g.addEdge(first, second);
        }
        return g;
    }

    static ArrayList<String> buildOrder(Graph<String> graph) {
        ArrayList<String> order = new ArrayList<>();
        HashMap<String, Integer> depCount = new HashMap<>();

        // Calculate the number of incoming dependencies for each node
        for (String node : graph.getNodes()) {
            depCount.put(node, 0);
        }
        for (String node : graph.getNodes()) {
            ArrayList<String> neighbors = new ArrayList<>(graph.getNeighbors(node));
            for (String neighbor : neighbors) {
                depCount.put(neighbor, depCount.getOrDefault(neighbor, 0) + 1);
            }
        }

        // Initialize a queue for nodes with no incoming dependencies
        Queue<String> queue = new LinkedList<>();
        for (String node : depCount.keySet()) {
            if (depCount.get(node) == 0) {
                queue.offer(node);
            }
        }

        // Process nodes in topological order
        int toBeProcessed = 0; // Initialize to 0
        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);

            ArrayList<String> neighbors = new ArrayList<>(graph.getNeighbors(current));
            for (String neighbor : neighbors) {
                depCount.put(neighbor, depCount.get(neighbor) - 1);
                if (depCount.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
            toBeProcessed++; // Increment the counter
        }

// Check if there's a valid build order (no cyclic dependencies)
        if (toBeProcessed != graph.getNodes().size()) {
            return null; // Cyclic dependencies detected
        }

        return order;
    }
}

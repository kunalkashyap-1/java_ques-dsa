package ctci.graph;

import java.util.*;

class Graph<T> {
    private final Map<T, LinkedList<T>> adjacencyList;
    private final ArrayList<T> nodes = new ArrayList<>();

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(T source, T destination) {
        if (!adjacencyList.containsKey(source)) {
            adjacencyList.put(source, new LinkedList<>());
            nodes.add(source);
        }
        adjacencyList.get(source).add(destination);
    }

    public ArrayList<T> getNodes(){return nodes;}

    public LinkedList<T> getNeighbors(T node){
        return adjacencyList.get(node);
    }
    public boolean hasRouteBFS(T source, T destination) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            return false;
        }

        Queue<T> queue = new LinkedList<>();
        boolean[] visited = new boolean[1000];
//remove T with ints had to change it
        queue.add(source);
        while (!queue.isEmpty()) {
            T current = queue.poll();
            visited[(int)current] = true;

            if (current == destination) {
                return true;
            }

            LinkedList<T> neighbours = adjacencyList.get(current);
            if (neighbours != null) {
                for (T neighbour : neighbours) {
                    if (!visited[(int)neighbour]) {
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
        Graph<Integer> g = new Graph<>();
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

import java.util.*;

public class FordFulkerson {
    boolean[] marked;
    Edge[] edgeTo;
    int value;

    public FordFulkerson(FlowNetwork G, int s, int t) {
        value = 0;

        while (hasAugmentingPath(G, s, t)) {
            int bottleneck = Integer.MAX_VALUE;

            // Find bottleneck capacity
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                bottleneck = Math.min(bottleneck, edgeTo[v].residualCapacityTo(v));
            }

            // Show path
            System.out.print("Path found, adding flow: " + bottleneck + "\nPath: ");
            List<Integer> path = new ArrayList<>();
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                path.add(v);
            }
            path.add(s);
            Collections.reverse(path);
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i != path.size() - 1) System.out.print(" -> ");
            }
            System.out.println();

            // Add flow along the path
            for (int v = t; v != s; v = edgeTo[v].other(v)) {
                edgeTo[v].addResidualFlowTo(v, bottleneck);
            }

            value += bottleneck;
        }
    }

    private boolean hasAugmentingPath(FlowNetwork G, int s, int t) {
        marked = new boolean[G.V];
        edgeTo = new Edge[G.V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        marked[s] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (Edge e : G.adj(v)) {
                int w = e.other(v);
                if (!marked[w] && e.residualCapacityTo(w) > 0) {
                    edgeTo[w] = e;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
        return marked[t];
    }

    public int value() {
        return value;
    }
}

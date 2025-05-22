import java.util.*;

public class FlowNetwork {
    int V;
    List<Edge>[] adj;

    public FlowNetwork(int V) {
        this.V = V;
        adj = new List[V];
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();
    }

    public void addEdge(Edge e) {
        adj[e.from].add(e);
        adj[e.to].add(e);
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        List<Edge> list = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if (e.to != v) list.add(e); // avoid duplicates
            }
        }
        return list;
    }
}

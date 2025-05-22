public class Edge {
    int from, to, capacity, flow;

    public Edge(int from, int to, int capacity) {
        this.from = from;
        this.to = to;
        this.capacity = capacity;
        this.flow = 0;
    }

    public int residualCapacityTo(int vertex) {
        if (vertex == to) return capacity - flow;
        if (vertex == from) return flow;
        return 0;
    }

    public void addResidualFlowTo(int vertex, int delta) {
        if (vertex == to) flow += delta;
        else if (vertex == from) flow -= delta;
    }

    public int other(int vertex) {
        return (vertex == from) ? to : from;
    }
}


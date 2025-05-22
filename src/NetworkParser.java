import java.io.*;
import java.util.*;

public class NetworkParser {
    public static FlowNetwork parseFile(String filename) throws IOException {
        Scanner sc = new Scanner(new File(filename));
        int V = sc.nextInt();
        FlowNetwork network = new FlowNetwork(V);
        while (sc.hasNextInt()) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cap = sc.nextInt();
            Edge e = new Edge(from, to, cap);
            network.addEdge(e);
        }
        sc.close();
        return network;
    }
}

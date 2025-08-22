import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Edge implements Comparable<Edge> {
    int u, v, weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "u=" + u +
                ", v=" + v +
                ", weight=" + weight +
                '}';
    }
}

public class Main {

    static int N, M;
    static List<Integer> disjointSet;
    static List<Edge> edges;
    static List<Edge> resultEdge; // 최소 신장 트리 간선을 파악 위함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        disjointSet = IntStream.rangeClosed(0, N).boxed().collect(Collectors.toList());
        edges = new ArrayList<>();
        resultEdge = new ArrayList<>();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, weight));
        }

        Collections.sort(edges);

        for (Edge e : edges) {
            if (findSet(e.u) != findSet(e.v)) {
                resultEdge.add(e);
                unionSet(e.u, e.v);
            }
        }

        int result = 0;
        for (Edge e : resultEdge) result += e.weight;

        System.out.print(result);
    }

    static int findSet(int a) {
        if (disjointSet.get(a) != a) disjointSet.set(a, findSet(disjointSet.get(a)));
        return disjointSet.get(a);
    }

    static void unionSet(int a, int b) {
        int rootA = findSet(a);
        int rootB = findSet(b);
        if (rootA != rootB) {
            disjointSet.set(rootB, rootA);
        }
    }

}
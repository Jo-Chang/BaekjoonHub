import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

class Vertex implements Comparable<Vertex> {
    int v;
    int w;

    Vertex(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Vertex o) {
        return Integer.compare(this.w, o.w);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "v=" + v +
                ", w=" + w +
                '}';
    }
}

public class Main {

    static final int INF = 0x6FFFFFFF;

    static int V, E, K;
    static List<List<Vertex>> graph;
    static List<Integer> dist;
    static PriorityQueue<Vertex> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(Collections.nCopies(V + 1, null));
        for (int i = 0; i <= V; i++) {
            graph.set(i, new ArrayList<>());
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int tu = Integer.parseInt(st.nextToken());
            int tv = Integer.parseInt(st.nextToken());
            int tw = Integer.parseInt(st.nextToken());
            graph.get(tu).add(new Vertex(tv, tw));
        }

        dist = new ArrayList<>(Collections.nCopies(V + 1, INF));
        dist.set(K, 0);

        q.add(new Vertex(K, dist.get(K)));
        while (!q.isEmpty()) {
            Vertex pres = q.poll();

            for (Vertex next : graph.get(pres.v)) {
                int newDist = pres.w + next.w;
                if (dist.get(next.v) > newDist) {
                    dist.set(next.v, newDist);
                    q.add(new Vertex(next.v, newDist));
                }
            }
        }

        printDistance();
    }

    public static void printDistance() {
        for (int i = 1; i <= V; i++) {
            if (dist.get(i) == INF) System.out.println("INF");
            else System.out.println(dist.get(i));
        }
    }

}
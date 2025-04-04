import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    class Node {
        int v, weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    void sol() throws IOException {
        int v = read(), e = read(), weightSum = 0;
        ArrayList<Node>[] graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            int a = read(), b = read(), c = read();

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        boolean[] visited = new boolean[v + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.v]) continue;
            visited[cur.v] = true;
            weightSum += cur.weight;

            for (Node adj : graph[cur.v]) {
                if (visited[adj.v]) continue;
                pq.offer(adj);
            }
        }

        System.out.println(weightSum);
    }


    int read() throws IOException {
        int c = System.in.read(), n = 0, minus = 1;

        if (c == '-') minus = -1;
        else n = c & 15;

        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);

        return n * minus;
    }

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

}
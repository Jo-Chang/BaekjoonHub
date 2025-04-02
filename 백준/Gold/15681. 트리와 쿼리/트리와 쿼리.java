import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    class Node {
        int num, subTreeCnt;
        LinkedList<Integer> childs;

        public Node(int num) {
            this.num = num;
        }
    }

    LinkedList<Integer>[] graph;
    Node[] tree;
    boolean[] visited;

    public static void main(String[] args) throws IOException {
        new Main().sol();
    }

    int read() throws IOException {
        int c = System.in.read(), n = 0, minus = 1;

        if (c == '-') minus = -1;
        else n = c & 15;

        while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);

        return n * minus;
    }

    void sol() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = read(), r = read(), q = read();
        graph = new LinkedList[n + 1];
        tree = new Node[n + 1];
        visited = new boolean[graph.length];

        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
            tree[i] = new Node(i);
            tree[i].childs = new LinkedList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = read(), v = read();

            graph[u].add(v);
            graph[v].add(u);
        }

        setTree(r);

        for (int i = 0; i < q; i++) {
            sb.append(tree[read()].subTreeCnt);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    int setTree(int r) {
        if (r < 1) return -1;

        visited[r] = true;
        int cnt = 1;

        for (int next : graph[r]) {
            if (visited[next]) continue;

            tree[r].childs.add(next);
            cnt += setTree(next);
        }

        tree[r].subTreeCnt = cnt;

        return cnt;
    }

}
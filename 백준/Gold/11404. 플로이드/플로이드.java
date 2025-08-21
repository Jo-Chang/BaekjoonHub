import sun.security.provider.certpath.Vertex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static final int INF = 0xFFFFFFF;
    static int N, M;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(Collections.nCopies(N + 1, null));
        for (int i = 1; i <= N; i++) {
            graph.set(i, new ArrayList<>(Collections.nCopies(N + 1, INF)));
        }

        for (int m = 1; m <= M; m++) {
            st = new StringTokenizer(br.readLine());
            int tu = Integer.parseInt(st.nextToken());
            int tv = Integer.parseInt(st.nextToken());
            int tw = Integer.parseInt(st.nextToken());
            graph.get(tu).set(tv, Math.min(graph.get(tu).get(tv), tw));
        }

        for (int n = 1; n <= N; n++) {
            graph.get(n).set(n, 0);
        }

        for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    int mn = Math.min(graph.get(s).get(e), graph.get(s).get(m) + graph.get(m).get(e));
                    graph.get(s).set(e, mn);
                }
            }
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (graph.get(r).get(c) == INF) System.out.print("0 ");
                else System.out.print(graph.get(r).get(c) + " ");
            }
            System.out.println();
        }
    }

}
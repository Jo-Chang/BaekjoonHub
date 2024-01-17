import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Boj1504().solution();
  }
}

class Boj1504 {
  final int INF = Integer.MAX_VALUE;
  
  // List<Node>[] graph;
  ArrayList<Node> edges;
  StringBuilder sb;
  int N;

  void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    int testcase = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= testcase; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int W = Integer.parseInt(st.nextToken());

      // graph = new List[N + 1];
      // for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
      edges = new ArrayList<>();
      
      for (int i = 0; i < M + W; i++) {
        st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        if (i < M) {
          // graph[S].add(new Node(E, T));
          // graph[E].add(new Node(S, T));
          edges.add(new Node(S, E, T));
          edges.add(new Node(E, S, T));
        } else {
          // graph[S].add(new Node(E, -T));
          edges.add(new Node(S, E, -T));
        }
      }

      // boolean answer = bfs();
      boolean answer = bellmanFord();
      sb.append(answer? "NO" : "YES").append("\n");
    }

    br.close();
    System.out.println(sb);
  }

  boolean bellmanFord() {
    int[] vortex = new int[N + 1];
    Arrays.fill(vortex, INF);

    for (int x = 1; x <= N; x++) {
      if (vortex[x] != INF) continue;
      vortex[x] = 0;

      for (int i = 0; i < N; i++) {
        for (Node edge : edges) {
          if (vortex[edge.start] == INF) continue;
  
          int newTime = vortex[edge.start] + edge.time;
          if (newTime < vortex[edge.end]) {
            vortex[edge.end] = newTime;
  
            if (i == N - 1) return false;
          }
        }
      }
    }

    return true;
  }
}

class Node {
  int start, end, time;

  Node() {}
  Node(int start, int end, int time) {
    this.start = start;
    this.end = end;
    this.time = time;
  }
}
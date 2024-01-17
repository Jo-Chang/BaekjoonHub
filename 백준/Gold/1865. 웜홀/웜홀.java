import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Boj1865().solution();
  }
}

class Boj1865 {
  final int INF = Integer.MAX_VALUE;
  
  ArrayList<Edge> edges;
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

      edges = new ArrayList<>();
      
      for (int i = 0; i < M + W; i++) {
        st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        if (i < M) {
          edges.add(new Edge(S, E, T));
          edges.add(new Edge(E, S, T));
        } else {
          edges.add(new Edge(S, E, -T));
        }
      }

      boolean answer = bellmanFord();
      sb.append(answer? "NO" : "YES").append("\n");
    }

    br.close();
    System.out.println(sb);
  }

  boolean bellmanFord() {
    // 각 정점의 가중치 값이 아닌, 음순환만을 밝히기 위한 벨만-포드
    int[] vortex = new int[N + 1];
    
    for (int i = 0; i < N; i++) {
      for (Edge e : edges) {
        vortex[e.end] = Math.min(vortex[e.end], vortex[e.start] + e.time);    
      }
    }

    for (Edge e : edges) {
      if (vortex[e.end] > vortex[e.start] + e.time) return false;
    }

    return true;
  }
}

class Edge {
  int start, end, time;

  Edge(int start, int end, int time) {
    this.start = start;
    this.end = end;
    this.time = time;
  }
}
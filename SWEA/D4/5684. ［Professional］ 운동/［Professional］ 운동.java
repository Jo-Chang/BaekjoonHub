import java.io.*;
import java.util.*;


class Solution {
  final int INF = Integer.MAX_VALUE;

  int[][] graph;
  int N, M;
  
  public static void main(String[] args) throws IOException {
    new Solution().sol();
  }

  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      graph = new int[N + 1][N + 1];
      for (int i = 1; i <= N; i++) {
        Arrays.fill(graph[i], INF);
      }

      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        graph[S][E] = C;
      }
      
      dijkstra();

      int answer = INF;
      for (int i = 1; i <= N; i++) {
        if (graph[i][i] != 0) answer = Math.min(answer, graph[i][i]);
        for (int j = 1; j <= N; j++) {
          if (graph[i][j] == INF || graph[j][i] == INF || i == j) continue;

          answer = Math.min(answer, graph[i][j] + graph[j][i]);
        }
      }
      sb.append(String.format("#%d %d\n", tc, (answer == INF) ? -1 : answer));
    }
    br.close();

    System.out.println(sb);
  }

  void dijkstra() {
    for (int i = 1; i <= N; i++) {
      PriorityQueue<Node> pq = new PriorityQueue<>();
      pq.add(new Node(i, 0));

      int[] distance = new int[N + 1];
      Arrays.fill(distance, INF);
      
      while (!pq.isEmpty()) {
        Node node = pq.remove();
        int cd = node.destination;
        int cw = node.weight;

        for (int j = 1; j <= N; j++) {
          if (graph[cd][j] == INF) continue;
          
          int newWeight = cw + graph[cd][j];
          if (distance[j] > newWeight) {
            distance[j] = newWeight;
            pq.add(new Node(j, newWeight));
          }
        }
      }

      graph[i] = distance;
    }
  }

}

class Node implements Comparable<Node> {
  int destination, weight;

  Node(int destination, int weight) {
    this.destination = destination;
    this.weight = weight;
  }

  @Override
  public int compareTo(Node arg) {
    return weight - arg.weight;
  }
}
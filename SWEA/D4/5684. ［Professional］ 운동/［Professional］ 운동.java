import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      int answer = -1;
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int[][] graph = new int[N + 1][N + 1];
      int[][] distance = new int[N + 1][N + 1];
      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        graph[S][E] = C;
        distance[S][E] = C;
      }
      for (int i = 1; i <= N; i++) {
        for (int start = 1; start <= N; start++) {
          if (start == i) continue;
          for (int end = 1; end <= N; end++) {
            if (end == i || end == start) continue;
            if (distance[start][i] == 0 || distance[i][end] == 0) continue;

            if (distance[start][end] == 0) distance[start][end] = distance[start][i] + distance[i][end];
            else distance[start][end] = Math.min(distance[start][end], distance[start][i] + distance[i][end]);
          }
        }
      }
      for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
          if (i == j || graph[j][i] == 0 || distance[i][j] == 0) continue;
          int newDistance = distance[i][j] + graph[j][i];
          distance[i][i] = (distance[i][i] == 0) ? newDistance : Math.min(distance[i][i], newDistance);
        }
      }
      for (int i = 1; i <= N; i++) {
        if (distance[i][i] == 0) continue;
        
        answer = (answer == -1) ? distance[i][i] : Math.min(answer, distance[i][i]);
      }
      sb.append(String.format("#%d %d\n", tc, answer));
    }
    br.close();

    System.out.println(sb);
  }
}
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

    List<List<Integer>> graph = new ArrayList<>();
    // 헤더 포함한 이차원 리스트
    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
      if (!graph.get(a).contains(b)) {
        graph.get(a).add(b);
        graph.get(b).add(a);
      }
    }

    // 케빈 베이컨 수 구하기
    int[] kevinBacons = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      Deque<Integer> q = new LinkedList<>();
      int[] distances = new int[N + 1];
      boolean[] visited = new boolean[N + 1];
      q.add(i);
      visited[i] = true;
      while (!q.isEmpty()) {
        int current = q.remove();
        
        for (int destination : graph.get(current)) {
          if (!visited[destination]) {
            visited[destination] = true;
            distances[destination] = distances[current] + 1;
            q.add(destination);
          }
        }
      }

      for (int distance : distances) {
        kevinBacons[i] += distance;
      }
    }

    int answer = 1;
    for (int i = 2; i <= N; i++) {
      if (kevinBacons[answer] > kevinBacons[i]) answer = i;
    }
    
    System.out.println(answer);
  }
}
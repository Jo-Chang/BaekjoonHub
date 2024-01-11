import java.io.*;
import java.util.*;


public class Main {
  public static void main(String[] args) throws IOException {
    new Boj1238().solution();
  }
}


class Boj1238 {
  int N, M, X;
  int[][] graph;

  void solution() throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    graph = new int[N + 1][N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      graph[s][e] = w;
    }

    int[] dist = dijkstra();
    int[] reversedDist = reverseDijkstra();
    for (int i = 1; i <= N; i++) dist[i] += reversedDist[i];

    System.out.println(Arrays.stream(dist).filter(n -> n < 1000000).max().getAsInt());
  }

  int[] dijkstra() {
    int[] distance = new int[N + 1];
    Arrays.fill(distance, Integer.MAX_VALUE);

    PriorityQueue<Movement> pq = new PriorityQueue<>();
    pq.add(new Movement(X, 0));

    boolean[] visit = new boolean[N + 1];

    while (!pq.isEmpty()) {
      Movement cur = pq.remove();
      visit[cur.location] = true;

      for (int i = 1; i <= N; i++) {
        if (visit[i] || graph[cur.location][i] == 0) continue;

        int newDistance = cur.distance + graph[cur.location][i];
        if (newDistance <= distance[i]) {
          distance[i] = newDistance;
          pq.add(new Movement(i, newDistance));
        }
      }
    }

    return distance;
  }

  int[] reverseDijkstra() {
    int[] distance = new int[N + 1];
    Arrays.fill(distance, Integer.MAX_VALUE);

    PriorityQueue<Movement> pq = new PriorityQueue<>();
    pq.add(new Movement(X, 0));

    boolean[] visit = new boolean[N + 1];

    while (!pq.isEmpty()) {
      Movement cur = pq.remove();
      visit[cur.location] = true;

      for (int i = 1; i <= N; i++) {
        if (visit[i] || graph[i][cur.location] == 0) continue;

        int newDistance = cur.distance + graph[i][cur.location];
        if (newDistance <= distance[i]) {
          distance[i] = newDistance;
          pq.add(new Movement(i, newDistance));
        }
      }
    }

    return distance;
  }
}


class Movement implements Comparable<Movement> {
  int location, distance;

  Movement() {}
  Movement(int location, int distance) {
    this.location = location;
    this.distance = distance;
  }

  @Override
  public int compareTo(Movement arg) {
    return distance - arg.distance;
  }
}
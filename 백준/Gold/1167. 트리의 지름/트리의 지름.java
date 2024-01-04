import java.io.*;
import java.util.*;

public class Main {
  int V;
  LinkedList<Edge>[] tree;
  int[] distance;

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }

  void solution() throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    V = Integer.parseInt(br.readLine());
    tree = new LinkedList[V + 1];
    for (int i = 0; i < V; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int cur = Integer.parseInt(st.nextToken());
      tree[cur] = new LinkedList<>();
      while (true) {
        int next = Integer.parseInt(st.nextToken());
        if (next == -1) break;

        int weight = Integer.parseInt(st.nextToken());
        tree[cur].add(new Edge(next, weight));
      }
    }
    br.close();

    distance = new int[V + 1];
    dfs(1, 1);
    int node = 2;
    for (int i = 3; i <= V; i++) {
      if (distance[i] > distance[node]) node = i;
    }
    distance = new int[V + 1];
    dfs(node, node);
    int answer = Arrays.stream(distance).max().getAsInt();
    System.out.println(answer);
  }

  class Edge {
    int next, weight;

    Edge() {}
    Edge(int next, int weight) {
      this.next = next;
      this.weight = weight;
    }
  }

  void dfs(int start, int cur) {
    for (Edge e : tree[cur]) {
      if (e.next == start) continue;

      int newDistance = distance[cur] + e.weight;
      if (distance[e.next] > newDistance || distance[e.next] == 0) {
        distance[e.next] = newDistance;
        dfs(start, e.next);
      }
    }
  }
}
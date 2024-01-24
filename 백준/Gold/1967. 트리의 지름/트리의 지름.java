import java.io.*;
import java.util.*;


public class Main {
  public static void main(String[] args) throws IOException {
    new Boj1967().solution();
  }
}

class Boj1967 {
  final int INF = Integer.MAX_VALUE;

  int n;
  List<Node>[] tree;


  void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    
    tree = new List[n + 1];
    for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());

      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      tree[s].add(new Node(e, w));
      tree[e].add(new Node(s, w));
    }
    br.close();

    int[] distance;
    distance = dijkstra(1);
    distance = dijkstra(getMaxIndex(distance));

    System.out.println(distance[getMaxIndex(distance)]);
  }

  int[] dijkstra(int start) {
    int[] distance = new int[n + 1];
    Arrays.fill(distance, INF);
    distance[start] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));
    while (!pq.isEmpty()) {
      Node cur = pq.remove();
      int cd = cur.destination;
      int cw = cur.weight;

      for (Node e : tree[cd]) {
        int nw = cw + e.weight;
        if (nw < distance[e.destination]) {
          distance[e.destination] = nw;
          pq.add(new Node(e.destination, nw));
        }
      }
    }

    return distance;
  }

  int getMaxIndex(int[] arr) {
    int idx = 0;

    for (int i = 1; i < arr.length; i++) {
      if (arr[idx] == INF) idx = i;
      if (arr[i] == INF) continue;

      idx = (arr[i] > arr[idx])? i : idx;
    }

    return idx;
  }
}

class Node implements Comparable<Node> {
  int destination, weight;

  Node (int destination, int weight) {
    this.destination = destination;
    this.weight = weight;
  }

  @Override
  public int compareTo(Node arg) {
    return this.weight - arg.weight;
  }
}
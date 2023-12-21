import java.io.*;
import java.util.*;

class Main {
  final boolean DEBUG = false;
  int N, M;
  LinkedList<LinkedList<Integer>> graph;
  boolean[] ladderOrSnake;
  int[] distance;

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }

  void solution() throws IOException {
    graphInit();
    input();

    bfs();

    debug();
    debug2();

    System.out.println(distance[100]);
  }

  void graphInit() {
    graph = new LinkedList<>();
    graph.add(new LinkedList<>());
    for (int i = 1; i <= 100; i++) {
      graph.add(new LinkedList<>());
      for (int j = i + 1; j <= i + 6; j++) {
        if (j > 100) continue;
        
        graph.get(i).add(j);
      }
    }
    distance = new int[101];
    ladderOrSnake = new boolean[101];
  }
  
  void input() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    for (int i = 0; i < N + M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      graph.set(start, new LinkedList<>(Arrays.asList(end)));
      ladderOrSnake[start] = true;
    }
    br.close();
  }

  void bfs() {
    Deque<Integer> q = new LinkedList<>();
    q.add(1);
    while (!q.isEmpty()) {
      int cur = q.remove();
      
      if (cur == 100) return;

      if (ladderOrSnake[cur]) {
        // Snake or Ladder
        int next = graph.get(cur).peekFirst();
        if (distance[next] > distance[cur] || (next > 1 && distance[next] == 0)) {
          distance[next] = distance[cur];
          q.add(next);
        }
      } else {
        // Dice
        for (int next : graph.get(cur)) {
          if (distance[next] > distance[cur] + 1 || (distance[next] == 0 && next > 1)){
            distance[next] = distance[cur] + 1;
            q.add(next);
          }
        }
      }
    }
  }

  void debug() {
    if (!DEBUG) return;

    System.out.println("\nDebug! ");
    for (int i = 0; i <= 100; i++) {
      if (i % 10 == 0) System.out.print(String.format("\n#%2d : ", i / 10));
      System.out.print(distance[i] + " ");
    }
    System.out.println("\nDebug End");
  }

  void debug2() {
    if (!DEBUG) return;

    System.out.println("\nDebug! ");
    int idx = 0;
    for (LinkedList<Integer> list : graph) {
      System.out.print(String.format("\n#%2d : ", idx++));
      for (int ele : list) {
        System.out.print(String.format("%2d ", ele));
      }
    }
    System.out.println("\nDebug End");
  }
}
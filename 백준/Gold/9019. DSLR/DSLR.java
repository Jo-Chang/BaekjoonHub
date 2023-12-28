import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= T; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());

      boolean[] visited = new boolean[10000];
      Deque<Pair> q = new LinkedList<>();
      q.add(new Pair(A, ""));
      visited[A] = true;
      while (!q.isEmpty()) {
        Pair cur = q.remove();

        if (cur.num == B) {
          sb.append(cur.moves).append("\n");
          break;
        }

        int next = D(cur.num);
        if (!visited[next]) {
          q.add(new Pair(next, cur.moves + "D"));
          visited[next] = true;
        }
        next = S(cur.num);
        if (!visited[next]) {
          q.add(new Pair(next, cur.moves + "S"));
          visited[next] = true;
        }
        next = L(cur.num);
        if (!visited[next]) {
          q.add(new Pair(next, cur.moves + "L"));
          visited[next] = true;
        }
        next = R(cur.num);
        if (!visited[next]) {
          q.add(new Pair(next, cur.moves + "R"));
          visited[next] = true;
        }
      }
    }
    br.close();
    System.out.println(sb);
  }

  static int D(int n) {
    return (2 * n % 10000);
  }

  static int S(int n) {
    return (n == 0 ? 9999 : (n - 1));
  }

  static int L(int n) {
    return ((n * 10 + n / 1000) % 10000);
  }

  static int R(int n) {
    return (n / 10 + n % 10 * 1000);
  }

  static class Pair {
    int num;
    String moves;

    Pair(int num, String move) {
      this.num = num;
      this.moves = move;
    }
  }
}
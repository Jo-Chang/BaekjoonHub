import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Boj2206().sol();
  }
}

class Boj2206 {
  final int[][] DELTA = {
      { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
  };
  final int INF = Integer.MAX_VALUE;

  int N, M;
  char[][] map;

  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
    }
    br.close();

    System.out.println(bfs());
  }

  int bfs() {
    Queue<Location> pq = new LinkedList<>();
    pq.add(new Location(0, 0, 1, true));

    boolean[][][] visit = new boolean[N][M][2];

    while (!pq.isEmpty()) {

      Location cur = pq.remove();
      int x = cur.x;
      int y = cur.y;
      if (x == N - 1 && y == M - 1) return cur.distance;

      for (int[] dt : DELTA) {
        int nx = x + dt[0];
        int ny = y + dt[1];
        if (isOutside(nx, ny)) continue;

        if (map[nx][ny] == '0') {
          if (cur.isBreakable && !visit[nx][ny][0]) {
            pq.add(new Location(nx, ny, cur.distance + 1, cur.isBreakable));
            visit[nx][ny][0] = true;
          } else if (!cur.isBreakable && !visit[nx][ny][1]) {
            pq.add(new Location(nx, ny, cur.distance + 1, cur.isBreakable));
            visit[nx][ny][1] = true;
          }
        }
        else if (cur.isBreakable) {
          pq.add(new Location(nx, ny, cur.distance + 1, false));
          visit[nx][ny][1] = true;
        }
      }

    }

    return -1;
  }

  boolean isOutside(int x, int y) {
    return !(0 <= x && x < N && 0 <= y && y < M);
  }
}


class Location {
  int x, y, distance;
  boolean isBreakable;

  Location(int x, int y, int distance, boolean flag) {
    this.x = x;
    this.y = y;
    this.distance = distance;
    this.isBreakable = flag;
  }
}
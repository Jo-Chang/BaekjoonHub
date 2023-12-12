import java.io.*;
import java.util.*;

public class Main {
  static final boolean DEBUG = false;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int answer = 0;

    // 입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());
    int[][][] tomatoes = new int[H][N][M];
    ArrayList<Position> unripped = new ArrayList<>();
    ArrayList<Position> ripped = new ArrayList<>();
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
          tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
          if (tomatoes[i][j][k] == 0) {
            unripped.add(new Position(i, j, k));
          } else if (tomatoes[i][j][k] == 1) {
            ripped.add(new Position(i, j, k));
          }
        }
      }
    }

    // 토마토 숙성도 변화
    answer = changeTomatoes(tomatoes, ripped);

    // 안 익은 토마토 확인
    answer = checkUnripped(tomatoes, unripped, answer);

    // Debug
    if (DEBUG)
      printTomatoes(tomatoes);

    System.out.println(answer);
    br.close();
  }

  static int changeTomatoes(int[][][] tomatoes, ArrayList<Position> ripped) {
    int result = 0;
    Queue<Position> q = new LinkedList<>();
    int[][] delta = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
    int h = tomatoes.length;
    int n = tomatoes[0].length;
    int m = tomatoes[0][0].length;

    for (Position pos : ripped) {
      q.add(pos);
    }
    while (!q.isEmpty()) {
      Position p = q.remove();
      result = Math.max(tomatoes[p.h][p.n][p.m] - 1, result);

      for (int[] dt : delta) {
        Position np = new Position(p.h + dt[0], p.n + dt[1], p.m + dt[2]);

        if (0 <= np.h && np.h < h && 0 <= np.n && np.n < n && 0 <= np.m && np.m < m) {
          int cnt = tomatoes[p.h][p.n][p.m] + 1;
          if (tomatoes[np.h][np.n][np.m] == 0) {
            if (DEBUG) {
              System.out.println("Debug!");
              System.out.println(np.h + ", " + np.n + ", " + np.m);
            }
            tomatoes[np.h][np.n][np.m] = cnt;
            q.add(np);
          }
        }
      }

    }
    return result;
  }

  static int checkUnripped(int[][][] tomatoes, ArrayList<Position> unripped, int answer) {
    for (Position p : unripped) {
      if (tomatoes[p.h][p.n][p.m] == 0)
        return -1;
    }
    return answer;
  }

  static void printTomatoes(int[][][] tomatoes) {
    System.out.println("\nDebug!!");
    for (int i = 0; i < tomatoes.length; i++) {
      for (int j = 0; j < tomatoes[0].length; j++) {
        for (int k = 0; k < tomatoes[0][0].length; k++) {
          System.out.printf("%2d ", tomatoes[i][j][k]);
        }
        System.out.println();
      }
      System.out.println("==========");
    }
    System.out.println("Debug End");
  }
}

class Position {
  int n, m, h;

  public Position() {
    this.n = 0;
    this.m = 0;
    this.h = 0;
  }

  public Position(int h, int n, int m) {
    super();
    this.n = n;
    this.m = m;
    this.h = h;
  }
}
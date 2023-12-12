import java.io.*;
import java.util.*;

class Main {
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
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
          tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
        }
      }
    }

    // 토마토 숙성도 변화
    changeTomatoes(tomatoes);

    // 안 익은 토마토 확인
    answer = checkAllTomatoes(tomatoes);

    // Debug
    if (DEBUG) printTomatoes(tomatoes);

    System.out.println(answer);
    br.close();
  }

  static void changeTomatoes(int[][][] tomatoes) {
    Deque<Integer> q = new LinkedList<>();
    int[][] delta = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    int h = tomatoes.length;
    int n = tomatoes[0].length;
    int m = tomatoes[0][0].length;

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          if (tomatoes[i][j][k] == 1) {
            q.add(i);
            q.add(j);
            q.add(k);
            while (!q.isEmpty()) {
              int a = q.remove();
              int b = q.remove();
              int c = q.remove();

              for (int[] dt : delta) {
                int na = a + dt[0];
                int nb = b + dt[1];
                int nc = c + dt[2];

                if (0 <= na && na < h && 0 <= nb && nb < n && 0 <= nc && nc < m) {
                  if (tomatoes[na][nb][nc] == 0 || tomatoes[na][nb][nc] > tomatoes[a][b][c] + 1) {
                    tomatoes[na][nb][nc] = tomatoes[a][b][c] + 1;
                    q.add(na);
                    q.add(nb);
                    q.add(nc);
                  }
                }
              }
            }

            q.clear();
          }
        }
      }
    }
  }

  static int checkAllTomatoes(int[][][] tomatoes) {
    int result = 0;
    for (int i = 0; i < tomatoes.length; i++) {
      for (int j = 0; j < tomatoes[0].length; j++) {
        for (int k = 0; k < tomatoes[0][0].length; k++) {
          result = Math.max(result, tomatoes[i][j][k] - 1);
          if (tomatoes[i][j][k] == 0) return -1;
        }
      }
    }
    return result;
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
import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  int white = 0;
  int blue = 0;

  // 동적 프로그래밍 방법, 시간 초과
  void solution() throws IOException {
    int n = Integer.parseInt(br.readLine());
    int[][] board = new int[n][n];
    
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    split(board, n, 0, 0);

    System.out.printf("%d\n%d", white, blue);
  }

  void split(int[][] board, int n, int x, int y) {
    for (int i = x; i < x + n; i++) {
      for (int j = y; j < y + n; j++) {
        if (board[i][j] != board[x][y]) {
          split(board, n / 2, x, y);
          split(board, n / 2, x, y + n / 2);
          split(board, n / 2, x + n / 2, y);
          split(board, n / 2, x + n / 2, y + n / 2);
          return;
        }
      }
    }

    if (board[x][y] == 0) {
      white++;
    } else {
      blue++;
    }
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
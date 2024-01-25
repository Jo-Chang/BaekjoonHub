import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Boj1987().sol();
  }
}

class Boj1987 {
  final int[][] DELTA = {
    {1, 0}, {-1, 0}, {0, 1}, {0, -1}
  };

  char[][] board;
  int R, C;
  int answer;
  boolean[] visit;

  {
    answer = 0;
  }

  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    board = new char[R][C];
    for (int i = 0; i < R; i++) {
      String line = br.readLine();
      for (int j = 0; j < C; j++) {
        board[i][j] = line.charAt(j);
      }
    }
    br.close();

    visit = new boolean[26];
    setChecked(0, 0);
    dfs(0, 0, 1);

    System.out.println(answer);
  }

  void dfs(int x, int y, int depth) {
    for (int[] dt : DELTA) {
      int nx = x + dt[0];
      int ny = y + dt[1];
      if (!isInside(nx, ny)) continue;
      if (isChecked(nx, ny)) continue;
      
      setChecked(nx, ny);
      dfs(nx, ny, depth + 1);
      setUnchecked(nx, ny);
    }

    answer = Math.max(answer, depth);
  }

  void setChecked(int x, int y) {
    visit[board[x][y] - 'A'] = true;
  }
  void setUnchecked(int x, int y) {
    visit[board[x][y] - 'A'] = false;
  }

  boolean isInside(int x, int y) {
    return ((0 <= x && x < R && 0 <= y && y < C));
  }

  boolean isChecked(int x, int y) {
    return (visit[board[x][y] - 'A']);
  }
}
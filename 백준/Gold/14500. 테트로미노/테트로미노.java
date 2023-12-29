import java.io.*;
import java.util.StringTokenizer;

class Main {
  int N, M;
  int[][] delta = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  int[][] arr;
  int maxNum = 0, answer = 0;

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }

  void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        // maxNum = Math.max(maxNum, arr[i][j]);
      }
    }

    boolean[][] visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        visited[i][j] = true;
        answer = Math.max(answer, Math.max(dfs(visited, 0, i, j, arr[i][j]), checkT(i, j)));
        visited[i][j] = false;
      }
    }

    System.out.println(answer);
  }

  int dfs(boolean[][] visited, int depth, int x, int y, int sum) {
    if (depth == 3) return sum;
    // if (sum + maxNum * (4 - depth) < answer) return 0;
    
    int result = 0;
    for (int[] dt : delta) {
      int nx = x + dt[0];
      int ny = y + dt[1];
      
      if (!isInner(nx, ny) || visited[nx][ny]) continue;

      visited[nx][ny] = true;
      result = Math.max(result, dfs(visited, depth + 1, nx, ny, sum + arr[nx][ny]));
      visited[nx][ny] = false;
    }
    return result;
  }

  int checkT(int x, int y) {
    int result = 0;

    if (isInner(x + 1, y) && isInner(x - 1, y) && isInner(x, y + 1)) 
      result = arr[x][y] + arr[x + 1][y] + arr[x - 1][y] + arr[x][y + 1];
    if (isInner(x + 1, y) && isInner(x - 1, y) && isInner(x, y - 1)) 
      result = Math.max(result, arr[x][y] + arr[x + 1][y] + arr[x - 1][y] + arr[x][y - 1]);
    if (isInner(x + 1, y) && isInner(x, y + 1) && isInner(x, y - 1)) 
      result = Math.max(result, arr[x][y] + arr[x + 1][y] + arr[x][y + 1] + arr[x][y - 1]);
    if (isInner(x - 1, y) && isInner(x, y + 1) && isInner(x, y - 1)) 
      result = Math.max(result, arr[x][y] + arr[x - 1][y] + arr[x][y + 1] + arr[x][y - 1]);

    return result;
  }

  boolean isInner(int x, int y) {
    return ((0 <= x && x < arr.length) && (0 <= y && y < arr[0].length));
  }
}
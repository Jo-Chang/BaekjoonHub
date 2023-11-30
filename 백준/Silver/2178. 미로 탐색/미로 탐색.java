import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
    int[][] road = new int[n][m];
    int[][] distance = new int[n][m];
    int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        road[i][j] = line.charAt(j) - '0';
      }
    }
    br.close();

    Deque<Integer> q = new LinkedList<>();
    // (0, 0) 추가
    q.add(0);
    q.add(0);
    distance[0][0] = 1;
    while (!q.isEmpty()) {
      int x = q.remove();
      int y = q.remove();

      for (int[] dt : delta) {
        int nx = x + dt[0];
        int ny = y + dt[1];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if (distance[nx][ny] == 0 && road[nx][ny] == 1) {
            distance[nx][ny] = distance[x][y] + 1;
            q.add(nx);
            q.add(ny);
          } 
        }
      }
    }

    System.out.println(distance[n - 1][m - 1]);
  }
}
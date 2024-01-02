import java.io.*;
import java.util.*;

public class Main {
  int N, M;
  char[][] map;
  int[][] delta = {
    { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
  };
  int[] start;
  int count = 0;

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }

  void solution() throws IOException {
    // Input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = line.charAt(j);
        if (map[i][j] == 'I') {
          start = new int[]{i, j};
        }
      }
    }
    br.close();

    bfs();

    System.out.println(count == 0 ? "TT" : count);
  }

  void bfs() {
    Deque<int[]> q = new LinkedList<>(); 
    q.add(start);
    map[start[0]][start[1]] = 'V';
    
    while (!q.isEmpty()) {
      int[] cur = q.remove();

      for (int[] dt : delta) {
        int[] newP = new int[]{ cur[0] + dt[0], cur[1] + dt[1] };
        
        if (!isIn(newP)) continue;
        if (map[newP[0]][newP[1]] == 'V' || map[newP[0]][newP[1]] == 'X') continue;

        if (map[newP[0]][newP[1]] == 'P') count++;
        map[newP[0]][newP[1]] = 'V';
        q.add(newP);
      }
    }
  }

  boolean isIn(int[] pos) {
    return (0 <= pos[0] && pos[0] < N && 0 <= pos[1] && pos[1] < M);
  }
}
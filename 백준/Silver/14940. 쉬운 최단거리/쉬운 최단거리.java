import java.io.*;
import java.util.*;

public class Main {
	static class Pair {
		private int x, y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		int getX() {
			return this.x;
		}
		int getY() {
			return this.y;
		}
		
		void setPosition(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
		int[][] board = new int[n][m];
		int[][] dist = new int[n][m];
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
		
		Pair start = new Pair(-1, -1);
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					start.setPosition(i, j);
				} else if (board[i][j] == 0) dist[i][j] = 0;
        else dist[i][j] = -1;
			}
		}
		
		Deque<Pair> q = new LinkedList<>();
		dist[start.getX()][start.getY()] = 0;
    q.add(start);
		
		while (!q.isEmpty()) {
			Pair cur = q.remove();
			
      for (int i = 0; i < 4; i++) {
        int nx = cur.getX() + dx[i];
        int ny = cur.getY() + dy[i];

        if (isValidate(nx, ny, n, m)) {
          if (dist[nx][ny] == -1) {
            dist[nx][ny] = dist[cur.getX()][cur.getY()] + 1;
            q.add(new Pair(nx, ny));
          }
        }
      }
    }
		
    StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
        sb.append(dist[i][j]).append(" ");
			}
      sb.append("\n");
		}

    System.out.println(sb);
	}
	
	static boolean isValidate(int x, int y, int n, int m) {
		return (0 <= x && x < n && 0 <= y && y < m);
	}
}
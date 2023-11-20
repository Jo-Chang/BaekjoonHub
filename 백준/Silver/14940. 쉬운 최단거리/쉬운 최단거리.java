import java.io.*;
import java.util.*;

public class Main {
	static class Pair {
		private int x, y;
		
		public Pair() {
			this.x = -1;
			this.y = -1;
		}
		
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
		
		Pair start = new Pair();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					start.setPosition(i, j);
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
        if (board[i][j] == 0) dist[i][j] = 0;
        else dist[i][j] = -1;
			}
		}
		
		Deque<Pair> q = new LinkedList<>();
		dist[start.getX()][start.getY()] = 0;
    q.add(start);
		
		while (!q.isEmpty()) {
			Pair cur = q.remove();
			
			if (isValidate(cur.getX() + 1, cur.getY(), n, m)) {
        if (dist[cur.getX() + 1][cur.getY()] == -1) {
          dist[cur.getX() + 1][cur.getY()] = dist[cur.getX()][cur.getY()] + 1;
				  q.add(new Pair(cur.getX() + 1, cur.getY()));
        }
			} 
      if (isValidate(cur.getX() - 1, cur.getY(), n, m)) {
        if (dist[cur.getX() - 1][cur.getY()] == -1) {
				  dist[cur.getX() - 1][cur.getY()] = dist[cur.getX()][cur.getY()] + 1;
				  q.add(new Pair(cur.getX() - 1, cur.getY()));
        }
			} 
      if (isValidate(cur.getX(), cur.getY() + 1, n, m)) {
        if (dist[cur.getX()][cur.getY() + 1] == -1) {
          dist[cur.getX()][cur.getY() + 1] = dist[cur.getX()][cur.getY()] + 1;
				  q.add(new Pair(cur.getX(), cur.getY() + 1));
        }
			} 
      if (isValidate(cur.getX(), cur.getY() - 1, n, m)) {
        if (dist[cur.getX()][cur.getY() - 1] == -1) {
				  dist[cur.getX()][cur.getY() - 1] = dist[cur.getX()][cur.getY()] + 1;
				  q.add(new Pair(cur.getX(), cur.getY() - 1));
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
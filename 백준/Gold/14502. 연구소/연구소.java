import java.io.*;
import java.util.*;

class Main {
	
	final static int[][] DELTA = new int[][] {
			{1, 0}, {-1, 0}, {0, 1}, {0, -1}
	};
	static int n, m;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		
		n = readInt();
		m = readInt();
		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = readInt();
			}
		}
		
		System.out.println(getMaximumSafePlace());
		
	}
	
	static int getMaximumSafePlace() {
		int result = 0;
		
		for (int i = 0; i < n * m; i++) {

			int x1 = i / m;
			int y1 = i % m;
			if (map[x1][y1] != 0) continue;
			
			map[x1][y1] = 1;
			for (int j = i + 1; j < n * m; j++) {

				int x2 = j / m;
				int y2 = j % m;
				if (map[x2][y2] != 0) continue;
				
				map[x2][y2] = 1;
				for (int k = j + 1; k < n * m; k++) {
					int x3 = k / m;
					int y3 = k % m;
					if (map[x3][y3] != 0) continue;
					
					map[x3][y3] = 1;
					result = Math.max(result, getSafePlace());
					map[x3][y3] = 0;
				}
				map[x2][y2] = 0;
			}
			map[x1][y1] = 0;
		}
		
		return result;
	}
	
	static int getSafePlace() {
		int cnt = 0;
		Queue<Integer> q = new ArrayDeque<>();
		int[][] newMap = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				newMap[i][j] = map[i][j];
				if (map[i][j] == 2) {
					q.add(i);
					q.add(j);
				}
			}
		}
		
		while (!q.isEmpty()) {
			int x = q.poll();
			int y = q.poll();
			
			for (int[] dt : DELTA) {
				int nx = x + dt[0];
				int ny = y + dt[1];
				if (isOutside(nx, ny)) continue;
				if (newMap[nx][ny] == 0) {
					newMap[nx][ny] = 2;
					q.add(nx);
					q.add(ny);
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (newMap[i][j] == 0) cnt++;
			}
		}
		
		return cnt;
	}
	
	static boolean isOutside(int x, int y) {
		return !(0 <= x && x < n && 0 <= y && y < m);
	}
	
	static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		if (c == 11 || c == 13) System.in.read();
		
		return n;
	}
	
}
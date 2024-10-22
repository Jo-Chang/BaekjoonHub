import java.io.*;
import java.util.*;

public class Main {
	
	final static int[][] DELTA = new int[][] {
		{1, 0}, {0, 1}, {-1, 0}, {0, -1}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		boolean[][] graph = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph[i][j] = (num == 1);
			}
		}
		
		int count = 0, max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!graph[i][j]) continue;
				
				count++;
				List<Integer> q = new LinkedList<>();
				q.add(i);
				q.add(j);
				graph[i][j] = false;
				int area = 1;
				while (!q.isEmpty()) {
					int x = q.remove(0);
					int y = q.remove(0);
					
					for (int[] dt : DELTA) {
						int nx = x + dt[0];
						int ny = y + dt[1];
						
						if (isInField(nx, ny, n, m) && graph[nx][ny]) {
							graph[nx][ny] = false;
							area++;
							
							q.add(nx);
							q.add(ny);
						}
					}
				}
				
				max = Math.max(max, area);
			}
		}
		
		System.out.println(count);
		System.out.println(max);
	}
	
	static boolean isInField(int x, int y, int n, int m) {
		return 0 <= x && x < n && 0 <= y && y < m;
	}
}
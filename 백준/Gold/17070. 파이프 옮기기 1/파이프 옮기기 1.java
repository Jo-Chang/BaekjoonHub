import java.io.*;
import java.util.*;

class Main {
	
	static class Pipe {
		int direction, r, c;
		
		Pipe(int r, int c, int direction) {
			this.r = r;
			this.c = c;
			this.direction = direction;
		}
	}
	
	static final int HORIZONTAL = 0;
	static final int VERTICAL = 1;
	static final int DIAGONAL= 2;
	
	static int[][] MOVE = new int[][] {
		{0, 1}, {1, 0}, {1, 1}
	};
	
	static int n;
	static boolean[][] isWall;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		isWall = new boolean[n][n];
				
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				if (st.nextToken().equals("1")) isWall[i][j] = true;
			}
		}
		
		int answer = 0;
		
		Queue<Pipe> q = new ArrayDeque<>();
		q.add(new Pipe(0, 1, HORIZONTAL));
		
		while (!q.isEmpty()) {
			Pipe pipe = q.poll();
			int r = pipe.r;
			int c = pipe.c;
			
			if (r == n - 1 && c == n - 1) {
				answer++;
				continue;
			}
			
			for (int i = 0; i < MOVE.length; i++) {
				int newR = r + MOVE[i][0];
				int newC = c + MOVE[i][1];
				
				if (!isInner(newR, newC)) continue;
				if (isWall[newR][newC]) continue;
				
				if (i == HORIZONTAL && pipe.direction == VERTICAL) continue;
				if (i == VERTICAL && pipe.direction == HORIZONTAL) continue;
				if (i == DIAGONAL && (isWall[newR][c] || isWall[r][newC])) continue;
				
				q.add(new Pipe(newR, newC, i));
			}
			
		}
		
		System.out.println(answer);
		
	}
	
	static boolean isInner(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}
	
}
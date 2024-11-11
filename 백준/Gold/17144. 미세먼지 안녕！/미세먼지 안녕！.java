import java.io.*;

public class Main {
	
	static final int[][] DELTA = {
			{0, 1}, {0, -1}, {1, 0}, {-1, 0}
	};
	
	public static void main(String[] args) throws IOException {
		
		int answer = 0, r = read(), c = read(), t = read();
		int[][] a = new int[r][c];
		
		int upper = -1, lower = -1;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				a[i][j] = read();
				if (upper == -1 && a[i][j] == -1) {
					upper = i;
					lower = i + 1; 
				}
			}
		}
		
		for (int i = 0; i < t; i++) {
			nextCondition(a, upper, lower);
		}
		
		answer = getTotalDust(a);
		System.out.println(answer);
		
	}
	
	static int read() throws IOException {
		int c, n = 0;	
		boolean isMinus = false;
		while ((c = System.in.read()) > 32) {
			if (c == '-') isMinus = true;
			else n = (n << 3) + (n << 1) + (c & 15);
		}
		if (c == 13) System.in.read();
		return n * ((isMinus) ? -1 : 1);
	}
	
	static void nextCondition(int[][] a, int upper, int lower) {
//		print(a);
		spreadDust(a);
//		print(a);
		circulateWind(a, upper, lower);
//		print(a);
	}
	
	static void copy2DArray(int[][] origin, int[][] target) {
		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[0].length; j++) target[i][j] = origin[i][j];  
		}
	}
	
	static void sum2DArray(int[][] origin, int[][] target) {
		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin[i].length; j++) {
				target[i][j] += origin[i][j];
			}
		}
	}
	
	static void spreadDust(int[][] a) {
		int r = a.length, c = a[0].length;
		int[][] nextA = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a[i][j] <= 0) continue;
				
				for (int[] dt : DELTA) {
					int nx = i + dt[0], ny = j + dt[1];
					
					if (!isInner(a, nx, ny)) continue;
					if (a[nx][ny] == -1) continue;
					
					nextA[nx][ny] += a[i][j] / 5;
					nextA[i][j] -= a[i][j] / 5;
				}
			}
		}
		
		sum2DArray(nextA, a);
	}

	static void circulateWind(int[][] a, int upper, int lower) {
		int r = a.length, c = a[0].length;
		
		// upper
		for (int i = upper; i > 0; i--) {
			a[i][0] = a[i - 1][0];
		}
		for (int i = 0; i < c - 1; i++) {
			a[0][i] = a[0][i + 1];
		}
		for (int i = 0; i < upper; i++) {
			a[i][c - 1] = a[i + 1][c - 1];
		}
		for (int i = c - 1; i > 1; i--) {
			a[upper][i] = a[upper][i - 1];
		}
		a[upper][1] = 0;
		a[upper][0] = -1;
		
		// lower
		for (int i = lower; i < r - 1; i++) {
			a[i][0] = a[i + 1][0];
		}
		for (int i = 0; i < c - 1; i++) {
			a[r - 1][i] = a[r - 1][i + 1];
		}
		for (int i = r - 1; i > lower; i--) {
			a[i][c - 1] = a[i - 1][c - 1];
		}
		for (int i = c - 1; i > 1; i--) {
			a[lower][i] = a[lower][i - 1];
		}
		a[lower][1] = 0;
		a[lower][0] = -1;
	}
	
	static int getTotalDust(int[][] a) {
		int count = 0;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				count += a[i][j];
			}
		}
		
		count += 2; // 공기청정기 -2 제외 
		return count;
	}
	
	static boolean isInner(int[][] arr, int x, int y) {
		return 0 <= x && x < arr.length && 0 <= y && y < arr[0].length; 
	}
	
	static void print(int[][] a) {
		// Print
		System.out.println("\n====== Array ======");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%d ", a[i][j]);
			}
			System.out.println();
		}
		System.out.println("\n===================");
		//
	}
	
}
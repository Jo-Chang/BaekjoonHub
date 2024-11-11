import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		int n = read(), m = read();
		int a = read(), b = read(), c = read(), answer = Integer.MAX_VALUE;
		
		int[][] sum = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
				sum[i][j] += read();
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				int px, py, npx, npy;
				
				if (i <= n - (a) + 1 && j <= m - (b + c) + 1) {
					int clear = 0;
					
					px = i + a - 1;
					py = j + b + c - 1;
					clear = sum[px][py] - sum[i - 1][py] - sum[px][j - 1] + sum[i - 1][j - 1]; 
					
					answer = Math.min(answer, clear);
				}
				if (i <= n - (a + b) + 1 && j <= m - (a + c) + 1) {
					int clear = 0;
					
					px = i + a - 1;
					py = j + c - 1;
					clear = sum[px][py] - sum[i - 1][py] - sum[px][j - 1] + sum[i - 1][j - 1]; 
					
					npx = px + b;
					npy = py + a;
					clear += sum[npx][npy] - sum[px][npy] - sum[npx][py] + sum[px][py];
					
					answer = Math.min(answer, clear);
				}
				if (i <= n - (a + c) + 1 && j <= m - (b + a) + 1) {
					int clear = 0;
					
					px = i + a - 1;
					py = j + b - 1;
					clear = sum[px][py] - sum[i - 1][py] - sum[px][j - 1] + sum[i - 1][j - 1]; 
					
					npx = px + c;
					npy = py + a;
					clear += sum[npx][npy] - sum[px][npy] - sum[npx][py] + sum[px][py];
					
					answer = Math.min(answer, clear);
				}
				
			}
		}
		
		System.out.println(answer);
		
	}
	
	static int read() throws IOException {
		int c, n = System.in.read() & 15;	
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13) System.in.read();
		return n;
	}
	
}
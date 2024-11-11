import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		int n = read(), m = read();
		int a = read(), b = read(), c = read(), answer = Integer.MAX_VALUE;
		
		int [][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = read();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				
				if (j <= m - (b + c) && i <= n - (a)) {
					int clear = 0;
					for (int k = 0; k < a; k++) {
						for (int l = 0; l < b + c; l++) {
							clear += arr[i + k][j + l];
						}
					}
					
					answer = Math.min(answer, clear);
				}
				if (j <= m - (a + c) && i <= n - (a + b)) {
					int clear = 0;
					for (int k = 0; k < a; k++) {
						for (int l = 0; l < c; l++) {
							clear += arr[i + k][j + l];
						}
					}
					for (int k = 0; k < b; k++) {
						for (int l = 0; l < a; l++) {
							clear += arr[(i + a) + k][(j + c) + l];
						}
					}
					
					answer = Math.min(answer, clear);
				}
				if (j <= m - (b + a) && i <= n - (a + c)) {
					int clear = 0;
					for (int k = 0; k < a; k++) {
						for (int l = 0; l < b; l++) {
							clear += arr[i + k][j + l];
						}
					}
					for (int k = 0; k < c; k++) {
						for (int l = 0; l < a; l++) {
							clear += arr[(i + a) + k][(j + b) + l];
						}
					}
					
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
import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		int h = readInt(), w = readInt();
		int[][][] img = readImagePixel(h, w);

		int[][] dp = new int[h][w];
		for (int i = 0; i < w; i++) {
			int diff = img[0][0][i] - img[1][0][i];
			dp[0][i] = diff * diff;
		}
		
		for (int i = 1; i < h; i++) {
			dp[i][0] = dp[i - 1][0];
			if (w > 1) {
				dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
				
				dp[i][w - 1] = Math.min(dp[i - 1][w - 1], dp[i - 1][w - 2]);
				int lastDiff = img[0][i][w - 1] - img[1][i][w - 1];
				dp[i][w - 1] += lastDiff * lastDiff;
			}
			int firstDiff = img[0][i][0] - img[1][i][0];
			dp[i][0] += firstDiff * firstDiff;
			
			for (int j = 1; j < w - 1; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
				int diff = img[0][i][j] - img[1][i][j];
				dp[i][j] += diff * diff;
			}
			
		}
		
		System.out.println(getUnnaturality(dp[h - 1]));
		
	}
	
	static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13) System.in.read();
		return n;
	}
	
	static int[][][] readImagePixel(int h, int w) throws IOException {
		int[][][] arr = new int[2][h][w];
			
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				for (int k = 0; k < arr[0][0].length; k++) {
					arr[i][j][k] = readInt();
				}
			}
		}
		
		return arr;
	}
	
	static int getUnnaturality(int[] arr) {
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			result = Math.min(result, arr[i]);
		}
		return result;
	}
	
}
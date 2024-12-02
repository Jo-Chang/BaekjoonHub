import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		int[][] arr = new int[3][];
		for (int i = 0; i < 3; i++) arr[i] = new int[read()];
		int answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = read();
			}
			Arrays.sort(arr[i]);
		}
		
		
		for (int i = 0; i < arr[0].length; i++) {
			int a = arr[0][i], b = 0, c = 0;
			int b1 = getNearest(arr[1], a), b2 = 0;
			int c1 = getNearest(arr[2], a), c2 = getNearest(arr[2], b1);

			if (getPenalty(a, b1, c1) < getPenalty(a, b1, c2)) c = c1;
			else c = c2;
			
			b2 = getNearest(arr[1], c);
			
			if (getPenalty(a, b1, c) < getPenalty(a, b2, c)) b = b1;
			else b = b2;
			
			answer = Math.min(answer, getPenalty(a, b, c));
		}
		
		System.out.println(answer);
		
	}
	
	static int read() throws IOException {
		int c, n = 0;
		boolean minus = false;
		while ((c = System.in.read()) > 32) {
			if (c == '-') {
				minus = true;
				continue;
			}
			n = (n << 3) + (n << 1) + (c & 15);
		}
		if (c == 13) System.in.read();
		return n * (minus ? -1 : 1);
	}
	
	static int getPenalty(int a, int b, int c) {
		return Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
	}
	
	static int getNearest(int[] arr, int num) {
		int s = 0, e = arr.length - 1, mid = (s + e) / 2, nearest = arr[mid];
		
		while (s <= e) {
			mid = (s + e) / 2;
			
			if (arr[mid] == num) return arr[mid];
			else if (arr[mid] < num) s = mid + 1;
			else e = mid - 1;
			
			if (Math.abs(num - arr[mid]) < Math.abs(num - nearest)) nearest = arr[mid];
		}
		
		return nearest;
	}
	
}
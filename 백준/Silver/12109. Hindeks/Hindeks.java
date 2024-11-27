import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {

		int n = read();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = read();
		
		Arrays.sort(arr);
		
		for (int i = 1; i <= n; i++) {
			if (arr[n - i] < i) {
				System.out.println(i - 1);
				return;
			}
		}
		
		System.out.println(n);
		
	}
	
	static int read() throws IOException {
		int c, n = 0;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13) System.in.read();
		return n;
	}
	
}
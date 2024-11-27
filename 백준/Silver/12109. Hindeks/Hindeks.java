import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {

		int n = read(), answer = 0, idx = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = read();
		
		Arrays.sort(arr);
		
		for (int i = 1; i <= n; i++) {
			int num = arr[n - i];
			
			if (num < i) break;
			answer = i;
		}
		
		System.out.println(answer);
		
	}
	
	static int read() throws IOException {
		int c, n = 0;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13) System.in.read();
		return n;
	}
	
}
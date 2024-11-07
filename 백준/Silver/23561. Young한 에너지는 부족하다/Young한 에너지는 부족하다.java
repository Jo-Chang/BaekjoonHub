import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		int n = readInt();
		int[] arr = new int[3 * n];
		for (int i = 0; i < 3 * n; i++) arr[i] = readInt();
		
		Arrays.sort(arr);
		
		System.out.println(arr[2 * n - 1] - arr[n]);
		
	}
	
	static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13) System.in.read();
		return n;
	}
	
}
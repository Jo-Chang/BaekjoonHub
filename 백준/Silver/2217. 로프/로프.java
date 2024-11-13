import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		int n = read(), answer = 0;
		
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = read();
		}
		
		Arrays.sort(arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				return n2 - n1;
			}
		});
		
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, arr[i] * (i + 1));
		}
		
		System.out.println(answer);
		
	}
	
	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
		if (c == 13) System.in.read();
		return n;
	}
	
}
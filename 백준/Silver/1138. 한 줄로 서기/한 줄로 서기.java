import java.util.*;

public class Main {
	
	static char[][] arr;
	
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		int n = read();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) arr[i] = read();
		
		List<Integer> list = new ArrayList<>();
		for (int i = n - 1; i >= 0; i--) list.add(arr[i], i + 1);
		
		for (int num : list) sb.append(num).append(" ");
		
		System.out.println(sb);
	}
	
	static int read() throws Exception {
		int c, n = 0;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
}
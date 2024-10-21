import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		calculateSequence12(new int[m], 0, 0);
		
		System.out.println(sb);
	}
	
	static void calculateSequence12(int[] comb, int depth, int start) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(comb[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int last = 0;
		for (int i = start; i < n; i++) {
			if (arr[i] == last) continue;
			
			comb[depth] = arr[i];
			calculateSequence12(comb, depth + 1, i);
			last = arr[i];
		}
	}
}
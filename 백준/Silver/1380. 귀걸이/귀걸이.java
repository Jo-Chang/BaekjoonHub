import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n, senario = 1;
		while ((n = Integer.parseInt(br.readLine())) > 0) {
			String[] students = new String[n];
			int[] rings = new int[n];
			
			for (int i = 0; i < n; i++) {
				students[i] = br.readLine();
			}
			
			for (int i = 0; i < 2*n - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				
				rings[num - 1]++;
			}
			
			int idx = 0;
			for (int i = 0; i < n; i++) {
				if (rings[i] < 2) idx = i;
			}
			
			sb.append(String.format("%d %s\n", senario++, students[idx]));
		}
		
		System.out.println(sb);
		
	}
	
}
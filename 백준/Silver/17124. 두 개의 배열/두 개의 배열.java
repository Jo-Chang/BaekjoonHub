import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		while (tc-- > 0) {
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			int[] b = new int[m];
			int[] c = new int[n];
			
			long sum = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(b);
			
			for (int i = 0; i < n; i++) {
				
				int s = 0, e = m - 1, mid = 0;
				while (s <= e) {
					
					mid = (s + e) / 2;
					
					if (a[i] == b[mid]) {
						break;
					} else if (a[i] > b[mid]){
						s = mid + 1;
					} else {
						e = mid - 1;
					}
					
				}
				
				int diff1 = (mid > 0) ? Math.abs(a[i] - b[mid - 1]) : Integer.MAX_VALUE;
				int diff2 = Math.abs(a[i] - b[mid]);
				int diff3 = (mid < m -1) ? Math.abs(a[i] - b[mid + 1]) : Integer.MAX_VALUE;

				int min = Math.min(diff1, Math.min(diff2, diff3));
				
				if (min == diff1) {
					c[i] = b[mid - 1];
				} else if (min == diff2) {
					c[i] = b[mid];
				} else if (min == diff3) {
					c[i] = b[mid + 1];
				}
				
			}
			
			for (int i = 0; i < n; i++) {
				sum += c[i];
			}
			
			sb.append(sum).append("\n");
			
		}
		
		System.out.println(sb);
	}
	
}
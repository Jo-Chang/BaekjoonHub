import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();

		int tc = readInt();
		
		while (tc-- > 0) {
			
			int n = readInt();
			int m = readInt();
			int[] a = new int[n];
			int[] b = new int[m];
			int[] c = new int[n];
			
			for (int i = 0; i < n; i++) {
				a[i] = readInt();
			}
			
			for (int i = 0; i < m; i++) {
				b[i] = readInt();
			}
			
			Arrays.sort(b);
			
			for (int i = 0; i < n; i++) {

				int s = 0, e = m - 1, mid = 0;
				while (s <= e) {
					
					mid = (s + e) / 2;
					
					if (a[i] > b[mid]){
						s = mid + 1;
					} else {
						e = mid - 1;
					}
					
				}
				
				if (e < 0) c[i] = b[0];
				else if (s > m - 1) c[i] = b[m - 1];
				else {
					int diff1 = Math.abs(a[i] - b[s]);
					int diff2 = Math.abs(a[i] - b[e]);
					c[i] = (diff1 < diff2 ? b[s] : b[e]);
				}
				
			}
			
			long sum = 0;
			for (int i = 0; i < n; i++) {
				sum += c[i];
			}
			
			sb.append(sum).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static int readInt() throws IOException {
        int input, num = 0;
        
        while ((input = System.in.read()) > 32) {
        	num = (num << 3) + (num << 1) + (input & 15);
        }

        return num;
    }
}
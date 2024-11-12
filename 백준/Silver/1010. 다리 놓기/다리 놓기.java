import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		int tc = read();
		StringBuilder sb = new StringBuilder();
		
		while (tc-- > 0) {
			
			int n = read(), m = read();
			
			long num = 1, r = Math.max(n, m - n);
			for (int i = m; i > r; i--) {
				num *= i;
			}
			for (int i = 1; i <= m - r; i++) {
				num /= i;
			}
			
			sb.append(num).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13) System.in.read();
		return n;
	}
	
}
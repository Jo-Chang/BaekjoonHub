import java.io.*;

class Main {
	
	public static void main(String args[]) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		int n = read();
		
		for (int i = 0; i < n; i++) {
			StringBuffer sBuffer = new StringBuffer();
			int m = 2 * i + 1;
			if (m > n) m = 2 * (n - 1 - i) + 1;
			for (int j = 0; j < m; j++) sBuffer.append("*");
			for (int j = 0; j < n - m; j++) sBuffer.append(" ");
			sb.append(sBuffer).append(sBuffer.reverse());
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static int read() throws IOException {
		int c, n = 0;
		while ((c = System.in.read()) > 32) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		if (c == 13) System.in.read();
		return n;
	}
		
}
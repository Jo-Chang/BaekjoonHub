import java.io.*;

class Main {
	
	static int[][] combinations = new int[30][30];
	
	public static void main(String[] args) throws IOException {
		
		int tc = read();
		StringBuilder sb = new StringBuilder();
		
		while (tc-- > 0) {
			int n = read(), m = read();
			sb.append(comb(m, n)).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13) System.in.read();
		return n;
	}
	
	static int comb(int n, int r) {
		if (combinations[n][r] > 0) return combinations[n][r];
		if (r == 0 || r == n) return combinations[n][r] = 1;
		return combinations[n][r] = comb(n - 1, r) + comb(n - 1, r - 1);
	}
	
}
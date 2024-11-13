import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		int n = read(), m = read(), x = read(), prevX = x, answer = x;
		for (int i = 1; i < m; i++) {
			x = read();
			answer = Math.max(answer, (x - prevX) / 2 + (x - prevX) % 2);
			prevX = x;
		}
		answer = Math.max(answer, n - x);
		
		System.out.println(answer);
	}
	
	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
		if (c == 13) System.in.read();
		return n;
	}
	
}
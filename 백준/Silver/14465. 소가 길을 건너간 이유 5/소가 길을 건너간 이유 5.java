import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		int n = read(), k = read(), b = read(), answer = 0, cnt = 0;
		int[] streets = new int[n];
		
		for (int i = 0; i < b; i++) {
			int num = read();
			streets[num - 1] = 1;
			if (num <= k) answer++;
		}
		
		cnt = answer;
		for (int i = k; i < n; i++) {
			cnt += streets[i];
			cnt -= streets[i - k];
			answer = Math.min(answer, cnt);
		}
		
		System.out.println(answer);
		
	}
	
	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13) System.in.read();
		return n;
	}
	
}
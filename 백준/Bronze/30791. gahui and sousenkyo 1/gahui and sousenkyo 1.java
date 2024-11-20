import java.io.*;

class Main {
	
	public static void main(String args[]) throws Exception {
		
		int num16 = read(), answer = 0;
		for (int i = 1; i < 5; i++) {
			int num = read();
			
			if (num16 - num <= 1000) {
				answer = i;
			}
		}
		
		System.out.println(answer);
		
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
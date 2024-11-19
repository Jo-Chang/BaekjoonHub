import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {

		StringBuilder sb = new StringBuilder();
		long n = read();

		for (long i = 2; i * (i + 1) <= n << 1; i++) {
			long t = n / i, half = i >> 1, s = t - half, e = t + half;
			boolean b = false;
			if (i % 2 == 0) {
				s++;
				if (n % i != 0 && (double) n / i * 2 % 1 == 0) b = true;
			} else {
				if (n % i == 0) b = true;
			}
			
			if (b) sb.append(String.format("%d %d\n", s, e));
		}
		
		System.out.println(sb);
	}

	static long read() throws IOException {
		int c;
		long n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13)
			System.in.read();
		return n;
	}

}
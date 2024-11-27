import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {

		StringBuilder sb = new StringBuilder();
		int t = read();
		
		for (int tc = 1; tc <= t; tc++) {
			String result = "";
			
			int a = read(), b = read(), c = read(), sum = a + b + c;
			
			if (sum <= 2 * a || sum <= 2 * b || sum <= 2 * c) result = "invalid!";
			else if (a == b && b == c) result = "equilateral";
			else if (a == b || b == c || c == a) result = "isosceles";
			else result = "scalene";
			
			sb.append(String.format("Case #%d: %s\n", tc, result));
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
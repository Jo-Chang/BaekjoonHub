import java.util.*;

public class Main {
	
	static int a, b, c;
	
	public static void main(String[] args) throws Exception {
		
		a = read();
		b = read();
		c = read();
		int x1 = read(), x2 = read(), y1 = read(), y2 = read();
		
		int r[] = new int[4];
		r[0] = func(x1, y1);
		r[1] = func(x2, y1);
		r[2] = func(x1, y2);
		r[3] = func(x2, y2);
		
		String ans = "Lucky";
		
		loop:
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				if (r[i] * r[j] < 0) {
					ans = "Poor";
					break loop;
				}
			}
		}
		
		System.out.println(ans);
		
	}
	
	static int read() throws Exception {
		boolean minus = false;
		int c, n = 0;
		while ((c = System.in.read()) > 32) {
			if (c == '-') {
				minus = true;
				continue;
			}
			n = (n << 3) + (n << 1) + (c & 15);
		}
		return n * (minus ? -1 : 1);
	}
	
	static int func(int x, int y) {
		long sum = a * x + b * y + c;
		
		if (sum == 0) return 0;
		else if (sum > 0) return 1;
		else return -1;
	}
	
}
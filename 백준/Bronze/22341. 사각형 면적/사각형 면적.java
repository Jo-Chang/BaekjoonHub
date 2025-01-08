import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		int n = read(), c = read(), ans = 0, x = n, y = n;
		
		for (int i = 0; i < c; i++) {
			int nx = read(), ny = read();
			if (nx >= x || ny >= y) continue;
			
			int area1 = nx * y, area2 = ny * x;
			
			if (area1 >= area2) {
				x = nx;
			} else {
				y = ny;
			}
		}
		
		ans = x * y;
		
		System.out.println(ans);
	}
	
	static int read() throws IOException {
		int c, n = 0;
		while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
		return n;
	}
	
}
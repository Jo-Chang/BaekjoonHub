import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		int n = read(), ans = 0, last = -1, cnt1 = 0, cnt2 = 0;
		
		for (int i = 0; i < n; i++) {
			int num = read();
			
			if (num != last) {
				ans = Math.max(ans, cnt1 + cnt2);
				cnt1 = cnt2;
				cnt2 = 1;
				last = num;
			} else {
				cnt2++;
			}
		}
		
		ans = Math.max(ans, cnt1 + cnt2);
		
		System.out.println(ans);
		
	}
	
	static int read() throws IOException {
		int c, n = 0;
		while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
		return n;
	}
	
}
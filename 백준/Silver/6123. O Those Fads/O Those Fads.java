import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		int n = read(), l = read(), k = read(), ans = 0;
		Queue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) pq.add(read());
		for (int i = 0; i < n; i++) {
			if (pq.poll() <= l) {
				ans++;
				l += k;
			}
		}
		
		System.out.println(ans);
		
	}
	
	static int read() throws Exception {
		int c, n = 0;
		while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
		if (c==13) System.in.read();
		return n;
	}
	
}
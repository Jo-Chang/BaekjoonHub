import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		int n = read();
		double ans = 200_001;
		
		int[] ballons = new int[n];
		for (int i = 0; i < n; i++) ballons[i] = read();
		
		Arrays.sort(ballons);
		
		for (int i = 0; i < n; i++) {
			if (ballons[i] > i + 1) {
				ans = -1;
				break;
			}
			ans = Math.min(ans, (double) ballons[i] / (i + 1));
		}
		
		System.out.println(ans == -1 ? "impossible" : ans);
		
	}
	
	static int read() throws Exception {
		int c, n = 0;
		while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
		if (c==13) System.in.read();
		return n;
	}
	
}
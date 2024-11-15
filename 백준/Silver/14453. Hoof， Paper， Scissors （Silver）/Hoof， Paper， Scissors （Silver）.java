import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), answer = 0;
		int[][] dp = new int[n][6];
		
		for (int i = 0; i < n; i++) {
			String in = br.readLine();
			
			if (i > 0) dp[i] = dp[i - 1].clone();
			switch (in) {
			case "P":
				setDP(dp, i, 0);
				break;
			case "S":
				setDP(dp, i, 1);
				break;
			case "H":
				setDP(dp, i, 2);
				break;
			default:
				System.out.println("Wrong Input");
			}
		}
		
		for (int i = 0; i < 6; i++) {
			answer = Math.max(answer, dp[n - 1][i]);
		}
		
		System.out.println(answer);
		
	}
	
	static void setDP(int[][] dp, int i, int k) {
		if (i > 0) {
			dp[i][k] = dp[i - 1][k] + 1;
			dp[i][k + 3] = Math.max(dp[i - 1][k + 3], Math.max(dp[i - 1][(k + 1) % 3], dp[i - 1][(k + 2) % 3])) + 1;
		}
		else {
			dp[i][k]++;
			dp[i][k + 3]++;
		}
	}
	
}
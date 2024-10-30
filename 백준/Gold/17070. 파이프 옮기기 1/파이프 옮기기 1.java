import java.io.*;
import java.util.*;

class Main {
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		boolean[][] isWall = new boolean[n][n];
				
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				if (st.nextToken().equals("1")) isWall[i][j] = true;
			}
		}
		
		int[][][] dp = new int[n][n][3];
		dp[0][1][0] = 1;
		for (int i = 2; i < n; i++) {
			if (isWall[0][i]) continue;
			dp[0][i][0] = dp[0][i - 1][0];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				if (isWall[i][j]) continue;
				
				dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
				dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

				if (isWall[i][j - 1] || isWall[i - 1][j]) continue;
				dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
			}
		}
		
		int answer = 0;
		for (int i = 0; i < 3; i++) answer += dp[n - 1][n - 1][i];
		System.out.println(answer);
		
	}
	
}
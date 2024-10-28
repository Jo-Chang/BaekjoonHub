import java.io.*;
import java.util.*;

class Main {
	
	static int n, k;
	static int[] weights, values;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		weights = new int[n];
		values = new int[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			weights[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = calculateValues();
		
		System.out.println(answer);
	}
	
	static int calculateValues() {
		int[][] dp = new int[n][k + 1];
		
		if (weights[0] <= k) {
			dp[0][weights[0]] = values[0];
			dp[0][k] = dp[0][weights[0]];
		}
		
		for (int i = 1; i < n; i++) {
			dp[i] = dp[i - 1].clone();
			if (weights[i] > k) continue;

			dp[i][weights[i]] = Math.max(dp[i][weights[i]], values[i]);
			for (int j = k - weights[i]; j > 0; j--) {
				dp[i][j + weights[i]] = Math.max(
						dp[i - 1][j + weights[i]],
						dp[i - 1][j] + values[i]
						);
				
				dp[i][k] = Math.max(dp[i][k], dp[i][j + weights[i]]);
			}
		}
		
		return dp[n - 1][k];
	}
	
}
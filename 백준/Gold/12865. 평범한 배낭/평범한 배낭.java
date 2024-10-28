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
		int[] dp = new int[k + 1];
		
		for (int i = 0; i < n; i++) {
			for (int j = k; j >= weights[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
			}
		}
		
		return dp[k];
	}
	
}
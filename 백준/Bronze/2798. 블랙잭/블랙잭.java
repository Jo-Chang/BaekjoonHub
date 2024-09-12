import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] cards = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(getMaximumCombination(cards, m));
	}
	
	static int getMaximumCombination(int[] cards, int target) {
		int result = 0;
		int len = cards.length;
		
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				for (int k = j + 1; k < len; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if (sum <= target) 
						result = Math.max(result, sum);
				}
			}
		}
		
		return result;
	}
}
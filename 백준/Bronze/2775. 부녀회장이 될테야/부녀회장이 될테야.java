import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static final int MAX = 14;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[][] residents = new int[MAX + 1][];
		for (int i = 0; i <= MAX; i++) {
			residents[i] = new int[MAX + 1];
			if (i == 0) {
				for (int j = 1; j <= MAX; j++) {
					residents[i][j] = j;
				}
			} else {
				for (int j = 1; j <= MAX; j++) {
					for (int k = 1; k <= j; k++) {
						residents[i][j] += residents[i - 1][k];
					}
				}
			}
		}
		
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			sb.append(residents[k][n]).append("\n");
		}
		
		System.out.println(sb);
	}
}
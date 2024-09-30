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
		int k = Integer.parseInt(st.nextToken());
		
		System.out.println(combination(n, k));
	}
	
	static int combination(int n, int k) {
		int result = 1;
		
		for (int i = 0; i < k; i++) {
			result *= n - i;
			result /= i + 1;
		}
		
		return result;
	}
	
}
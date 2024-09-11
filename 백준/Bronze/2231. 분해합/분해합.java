import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		System.out.println(getMinimunContructNumber(n));
	}
	
	static int getMinimunContructNumber(int n) {
		for (int i = 1; i < n; i++) {
			if (n == getDisassembledSum(i)) return i;
		}
		return 0;
	}
	
	static int getDisassembledSum(int n) {
		int result = n;
		
		while (n > 0) {
			result += n % 10;
			n /= 10;
		}
		
		return result;
	}
}
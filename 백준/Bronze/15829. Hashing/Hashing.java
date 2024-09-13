import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	static final int MOD = 1_234_567_891;
	static final int R = 31;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String words = br.readLine();		
		
		System.out.println(hashing(words, n));
	}
	
	static int hashing(String words, int n) {
		long result = 0;
		long mul = 1;
		
		for (int i = 0; i < n; i++) {
			result += (words.charAt(i) - 'a' + 1) * mul % MOD;
			mul = mul * R % MOD;
		}
		
		return (int)result;
	}
	
}
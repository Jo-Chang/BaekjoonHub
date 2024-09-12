import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int i = 1;
		int sum = 1;
		while (sum < n) {
			sum += 6 * i++;
		}
		
		System.out.println(i);
		
	}
	
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	final static int MAX = 8;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] numbers = new int[MAX];
		for (int i = 0; i < MAX; i++) 
			numbers[i] = Integer.parseInt(st.nextToken());
		
		String result = "mixed";
		int diff = numbers[1] - numbers[0];
		for (int i = 2; i < MAX; i++) {
			if (numbers[i] - numbers[i - 1] != diff) {
				diff = 0;
				break;
			}
		}
		
		if (diff == 1) result = "ascending";
		else if (diff == -1) result = "descending";
		
		System.out.println(result);
	}
	
}
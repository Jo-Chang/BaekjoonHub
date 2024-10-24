import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int answer = 0, len = input.length();
		int[] sum = new int[len + 1];
		sum[0] = 0;
		
		for (int i = 1; i <= len; i++) {
			sum[i] = sum[i - 1] + input.charAt(i - 1) - '0';
		}
		
		for (int i = 0; i < len - 1; i++) {
			for (int j = len; j > i; j--) {
				if ((j - i) % 2 != 0) continue;
				int half = (j - i) / 2 + i;
				if (sum[j] - sum[half] == sum[half] - sum[i]) {
					answer = Math.max(answer, j - i);
				}
			}
		}
		
		System.out.println(answer);
	}
	
}
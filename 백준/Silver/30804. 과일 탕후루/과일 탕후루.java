import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		new Main().sol();
	}

	void sol() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		// int[] arr = new int[n];
		// StringTokenizer st = new StringTokenizer(br.readLine());
		String s = br.readLine();
		br.close();
		
		int answer = 0;
		int firstIdx = 0, secondIdx = -1, lastIdx = 0;
		for (int i = 0; i < s.length(); i += 2) {
			// arr[i] = Integer.parseInt(st.nextToken());
			
			if (secondIdx == -1 && s.charAt(firstIdx) != s.charAt(i)) {
				secondIdx = i;
			}
			else if (s.charAt(i) != s.charAt(firstIdx) && s.charAt(i) != s.charAt(secondIdx)) {
				answer = Math.max(answer, (i - firstIdx) / 2);
				// System.out.printf("first : %d, second : %d, now : %d\n", firstIdx, secondIdx, i);
				firstIdx = lastIdx;
				secondIdx = i;
			}

			if (s.charAt(i) != s.charAt(lastIdx)) lastIdx = i;
		}
		
		answer = Math.max(answer, n - firstIdx / 2);
		// System.out.printf("first : %d, second : %d, now : %d\n", firstIdx, secondIdx, n);

		System.out.println(answer);
	}
}
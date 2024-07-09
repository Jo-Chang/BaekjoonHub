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
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		int answer = 0;
		int firstIdx = 0, secondIdx = -1;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (secondIdx == -1 && arr[firstIdx] != arr[i]) {
				secondIdx = i;
			}
			else if (arr[i] != arr[firstIdx] && arr[i] != arr[secondIdx]) {
				answer = Math.max(answer, i - firstIdx);
				// System.out.printf("first : %d, second : %d, now : %d\n", firstIdx, secondIdx, i);
				for (int j = i - 2; j >= 0; j--) {
					if (arr[j] != arr[i - 1]) {
						firstIdx = j + 1;
						break;
					}
				}
				secondIdx = i;
			}
		}
		
		answer = Math.max(answer, n - firstIdx);
		// System.out.printf("first : %d, second : %d, now : %d\n", firstIdx, secondIdx, n);

		System.out.println(answer);
	}
}
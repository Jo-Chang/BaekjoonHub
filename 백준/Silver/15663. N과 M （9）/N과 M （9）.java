import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int[] numbers, comb;
	static int n, m;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		numbers = new int[n];
		comb = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numbers);

		addDistinctPermutation(0);

		System.out.println(sb);

	}

	static void addDistinctPermutation(int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(comb[i]).append(" ");
			}
			sb.append("\n");

			return;
		}

		int prev = 0;
		for (int i = 0; i < n; i++) {
			if (numbers[i] == 0 || numbers[i] == prev)
				continue;

			comb[depth] = numbers[i];
			prev = numbers[i];
			numbers[i] = 0;
			addDistinctPermutation(depth + 1);
			numbers[i] = comb[depth];
		}
	}

}
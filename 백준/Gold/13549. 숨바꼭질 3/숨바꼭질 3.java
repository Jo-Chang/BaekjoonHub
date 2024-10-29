import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Integer> q = new LinkedList<>();
		q.add(n);
		int[] positions = new int[200_000 + 1];
		Arrays.fill(positions, -1);
		positions[n] = 0;
		
		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int cur = q.remove(0);
			
			if (k > n && cur > 2 * k || cur < 0) continue;

			if (cur == k) answer = Math.min(answer, positions[cur]);
			if (positions[cur] >= answer) continue;

			if (cur < k)
				addQueue(q, positions, cur + 1, positions[cur] + 1);
			if (2 * cur - k <= k - cur)
				addQueue(q, positions, cur * 2, positions[cur]);
			addQueue(q, positions, cur - 1, positions[cur] + 1);
		}
		
		System.out.println(answer);
	}
	
	static void addQueue(List<Integer> q, int[] positions, int move, int depth) {
		if (move < 0) return;
		
		if (positions[move] == -1) {
			positions[move] = depth;
			q.add(move);
		} else if (positions[move] > depth) {
			positions[move] = depth;
			q.add(move);
		}
	}
	
}
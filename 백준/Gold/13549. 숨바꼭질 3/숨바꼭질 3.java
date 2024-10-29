import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Move {
		int num;
		int cnt;

		public Move(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}
	}

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] isVisited = new boolean[100001];

		Queue<Move> q = new ArrayDeque<>();
		q.add(new Move(N, 0));
		isVisited[N] = true;

		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {

			Move cur = q.poll();
			int num = cur.num;
			int cnt = cur.cnt;

			if (num == M) {
				min = Math.min(min, cnt);
				break;
			}

			if (num * 2 <= 100000 && !isVisited[num * 2]) {
				q.add(new Move(num * 2, cnt));
				isVisited[num * 2] = true;
			}

			if (num - 1 >= 0 && !isVisited[num - 1]) {
				q.add(new Move(num - 1, cnt + 1));
				isVisited[num - 1] = true;
			}

			if (num + 1 <= 100000 && !isVisited[num + 1]) {
				q.add(new Move(num + 1, cnt + 1));
				isVisited[num+1] = true;					
			}

		}

		sb.append(min);
		System.out.println(sb);
	}

}
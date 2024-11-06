import java.io.*;
import java.util.*;

class Main {
	
	static class Edge {
		int end, weight;
		
		public Edge(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		int n = readInt(), m = readInt(), r = readInt();

		List<Edge>[] graph = new List[n + 1];
		int[] items = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			items[i] = readInt();
			graph[i] = new LinkedList<>();
		}

		for (int i = 0; i < r; i++) {
			int a = readInt(), b = readInt(), l = readInt();
			graph[a].add(new Edge(b, l));
			graph[b].add(new Edge(a, l));
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		int[] distances = new int[n + 1];
		int answer = 0;
		
		for (int i = 1; i <= n; i++) {
			q.add(i);
			Arrays.fill(distances, -1);
			distances[i] = 0;
			
			int cnt = 0;
			while (!q.isEmpty()) {
				int cur = q.poll();
				
				for (Edge e : graph[cur]) {
					int newWeight = e.weight + distances[cur];
					if (newWeight > m) continue;
					if (newWeight < distances[e.end] || distances[e.end] < 0) {
						distances[e.end] = newWeight;
						q.add(e.end);
					}
				}
			}
			
			for (int j = 1; j <= n; j++) {
				if (distances[j] < 0) continue;
				cnt += items[j];
			}
			answer = Math.max(answer, cnt);
			q.clear();
		}
		
		System.out.println(answer);
		
	}
	
	static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 11 | c == 13) System.in.read();
		return n;
	}
	
}
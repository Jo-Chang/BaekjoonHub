import java.io.*;
import java.util.*;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int p, weight;
		
		Edge(int p, int weight) {
			this.p = p;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}
	
	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		
		int n = read(), m = read();
		List<Edge>[] g = new List[n + 1];
		for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
		
		for (int i = 0; i < m; i++) {
			g[read()].add(new Edge(read(), read()));
		}
		
		List<Integer> list = new LinkedList<>();
		int minDist = findMinDist(g, list, read(), read());
		
		sb.append(minDist).append("\n");
		sb.append(list.size()).append("\n");
		for (int p : list) sb.append(p).append(" ");
		
		System.out.println(sb);
		
	}
	
	static int read() throws IOException {
		int c, n = 0;
		while((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
		if (c == 13) System.in.read();
		return n;
	}

	static int findMinDist(List<Edge>[] g, List<Integer> list, int start, int end) {
		int[] dist = new int[g.length + 1], prev = new int[g.length + 1];;
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		Queue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (cur.weight >= dist[end]) continue;
			
			for (Edge e : g[cur.p]) {
				int next = e.p, newDist = dist[cur.p] + e.weight;
				
				if (newDist < dist[next]) {
					pq.add(new Edge(next, newDist));
					dist[next] = newDist;
					prev[next] = cur.p;
				}
			}
		}
		
		List<Integer> tmp = new LinkedList<>();
		int pos = end;
		while (pos > 0) {
			tmp.add(pos);
			pos = prev[pos];
		} 
		
		for (int t = tmp.size() - 1; t >= 0; t--) list.add(tmp.get(t));
		return dist[end];
	}
	
}
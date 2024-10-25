import java.io.*;
import java.util.*;

class Main {
	
	static Set<Integer>[] graph;
	static int[] distances;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
	 	graph = new Set[n + 1];
		for (int i = 1; i <= n; i++) graph[i] = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		distances = new int[n + 1];
		Arrays.fill(distances, -1);
		distances[r] = 0;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		dfs(r);
		
		for (int i = 1; i <= n; i++) {
			sb.append(distances[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int node) {
		for (int opposite : graph[node]) {
			if (distances[opposite] >= 0) continue;
			
			distances[opposite] = distances[node] + 1;
			dfs(opposite);
		}
	}
	
}
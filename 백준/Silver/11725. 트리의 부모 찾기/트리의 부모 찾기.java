import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		new Main().sol();
	}
	
	List<Integer>[] graph;
	
	void sol() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[n + 1];
		for(int i = 0; i < n; i++) {
			graph[i + 1] = new ArrayList<>();
		}
		
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			graph[node1].add(node2);
			graph[node2].add(node1);
		}
		br.close();
		
		int[] distance = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		LinkedList<Integer> queue = new LinkedList<>();
		int start = 1;
		queue.add(start);
		visited[start] = true;
		while (!queue.isEmpty()) {
			int cur = queue.removeFirst();
			
			for (int next : graph[cur]) {
				if (visited[next]) continue;
				
				visited[next] = true;
				distance[next] = distance[cur] + 1;
				queue.add(next);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 2; i <= n; i++) {
			int parent = 0;
			for (int op : graph[i]) {
				if (parent == 0) {
					parent = op;
					continue;
				}
				if (distance[op] < distance[parent]) {
					parent = op;
				}
			}
			
			sb.append(parent).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int answer = -1;

		List<Integer> q = new LinkedList<>();
		q.add(a);
		q.add(0);
		while (!q.isEmpty()) {
			long num = q.remove(0);
			int count = q.remove(0);
			
			long case1 = num * 2;
			long case2 = num * 10 + 1;
			
			if (case1 == b || case2 == b) {
				answer = count + 1 + 1;
				break;
			}
			
			if (case1 < b) {
				q.add((int)case1);
				q.add(count + 1);
			}
			
			if (case2 < b) {
				q.add((int)case2);
				q.add(count + 1);
			} 
		}

		System.out.println(answer);
	}
	
}
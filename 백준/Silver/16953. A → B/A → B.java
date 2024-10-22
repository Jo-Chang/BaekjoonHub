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
		q.add(b);
		q.add(0);
		while (!q.isEmpty()) {
			int num = q.remove(0);
			int count = q.remove(0);
			
			if (num < a) continue;
			else if (num == a) {
				answer = count + 1;
				break;
			}
			
			if (num % 10 == 1) {
				q.add(num / 10);
				q.add(count + 1);
			}
			if (num % 2 == 0) {
				q.add(num / 2);
				q.add(count + 1);
			}
		}

		System.out.println(answer);
	}
	
}
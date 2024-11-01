import java.io.*;
import java.util.*;

class Main {
	
	static final int LIMIT = 100_000;
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		int n = readInt();
		int k = readInt();
		
		int minTime = Integer.MAX_VALUE;
		int cnt = 0;
		
		boolean[] visit = new boolean[LIMIT + 1];
		
		Queue<Integer> q = new ArrayDeque<>();
		q.add(n);
		q.add(0);
		
		while (!q.isEmpty()) {
			int pos = q.poll();
			int time = q.poll();
			visit[pos] = true;
			
			if (time > minTime) break;
			if (pos == k) {
				if (time == minTime) {
					cnt++;
				} else {
					cnt = 1;
					minTime = time;
				}
				
				continue;
			}
			
			if (2 * pos <= LIMIT && !visit[pos * 2]) {
				q.add(pos * 2);
				q.add(time + 1);
			}
			if (pos > 0 && !visit[pos - 1]) {
				q.add(pos - 1);
				q.add(time + 1);
			}
			if (pos < LIMIT && !visit[pos + 1]) {
				q.add(pos + 1);
				q.add(time + 1);
			}
		}
		
		sb.append(minTime).append("\n");
		sb.append(cnt).append("\n");
		
		System.out.println(sb);
		
	}
	
	static int readInt() throws IOException {

		int input, num = System.in.read() & 15;
		
		while ((input = System.in.read()) > 32) 
			num = (num << 3) + (num << 1) + (input & 15);
		
		return num;
		
	}
	
}
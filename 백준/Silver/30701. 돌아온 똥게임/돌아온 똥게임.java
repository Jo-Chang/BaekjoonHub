import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {

		int n = (int) read(), answer = 0;
		long d = read();
		Queue<Long> monsterQ = new PriorityQueue<>(), equimentQ = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			int a = (int) read();
			long x = read();
			
			switch (a) {
			case 1:
				monsterQ.add(x);
				break;
			case 2:
				equimentQ.add(x);
				break;
			default:
				System.err.println("Wrong Input");	
			}
		}
		
		while (!monsterQ.isEmpty() && !equimentQ.isEmpty()) {
			long num = monsterQ.peek();
			
			if (num < d) {
				d += monsterQ.poll();
				answer++;
			}
			else {
				d *= equimentQ.poll();
				answer++;
			} 
		}
		
		while (!monsterQ.isEmpty()) {
			long num = monsterQ.poll();
			
			if (num < d) {
				d += num;
				answer++;
			} else break;
		}
		
		while (!equimentQ.isEmpty()) {
			equimentQ.poll();
			answer++;
		}

		System.out.println(answer);
		
	}
	
	static long read() throws IOException {
		int c; 
		long n = 0;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13) System.in.read();
		return n;
	}
	
}
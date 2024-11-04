import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		int n = readInt();
		int cntB = 0, cntS = 0;
		
		boolean[] euclidean = new boolean[n + 1];
		setPrime(euclidean);
		
		Deque<String> q = new ArrayDeque<>();
		boolean reverse = false;
		for (int i = 1; i <= n; i++) {
			if (euclidean[i]) {
				if (reverse) q.addFirst("B");
				else q.addLast("B");
				cntB++;
			} else {
				String str;
				if (reverse) {
					str = q.pollFirst();
					q.addFirst("S");
					q.addFirst("S");
				} else {
					str = q.pollLast();
					q.addLast("S");
					q.addLast("S");
				}
				
				if (str.equals("B")) {
					cntB--;
					cntS++;
				} else {
					reverse = !reverse;
				}
				
				cntS++;
			}
		}
		
		sb.append(cntB).append(" ").append(cntS);
		
		System.out.println(sb);
		
	}
	
	static int readInt() throws IOException {
		int input, num = System.in.read() & 15;
		
		while ((input = System.in.read()) > 32) 
			num = (num << 3) + (num << 1) + (input & 15);
		
		return num;
	}
	
	static void setPrime(boolean[] arr) {
		// false -> prime
		
		int len = arr.length - 1;
		arr[0] = arr[1] = true;
		
		for (int i = 2; i < len; i++) {
			
			if (arr[i]) continue;
			
			int num = i * 2;
			while (num <= len) {
				arr[num] = true;
				num += i;
			}
			
		}
		
	}
}
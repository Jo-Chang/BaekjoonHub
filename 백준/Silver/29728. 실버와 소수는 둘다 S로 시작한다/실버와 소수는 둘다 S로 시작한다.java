import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		int n = readInt();
		int cntB = 1, cntS = 0;
		
		boolean[] euclidean = new boolean[n + 1];
		setPrime(euclidean);
		
		char first = 'B', last = 'B';
		boolean reverse = false;
		for (int i = 2; i <= n; i++) {
			if (euclidean[i]) {
				if (reverse) first = 'B';
				else last = 'B';
				cntB++;
			} else {
				char ch;
				if (reverse) {
					ch = first;
					first = 'S';
				} else {
					ch = last;
					last = 'S';
				}
				
				if (ch == 'B') {
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
import java.io.*;

class Main {
	
	static int n, s;
	static boolean[] visit;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		
		n = readInt();
		s = readInt();
		arr = new int[n];
		visit = new boolean[n + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = readInt();
			visit[arr[i]] = true;
		}
		
		System.out.println(getSeqCount(0));
		
	}
	
	static int readInt() throws IOException {
		int input, num = System.in.read() & 15;
		
		while ((input = System.in.read()) > 32) {
			num = (num << 3) + (num << 1) + (input & 15);
		}
		
		if (input == 13) System.in.read();
		
		return num;
	}
	
	static int getSeqCount(int depth) {
		
		if (depth == n) {
			if (getCombCount(arr) == s) return 1;
			else return 0;
		} else if (arr[depth] > 0) {
			return getSeqCount(depth + 1);
		}
		
		int cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			if (visit[i]) continue;
			
			visit[i] = true;
			arr[depth] = i;
			cnt += getSeqCount(depth + 1);
			visit[i] = false;
			arr[depth] = 0;
		}
		
		return cnt;
				
	}
	
	static int getCombCount(int[] arr) {
		
		int cnt = 0, len = arr.length;
		
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (arr[i] < arr[j]) cnt++;
			}
		}
		
		return cnt;
		
	}
	
}
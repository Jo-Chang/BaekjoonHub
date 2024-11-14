import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		int a = read(), b = read(), d = read(), answer = 0;
		boolean[] isPrime = getEuclead(b);
		
		for (int i = a; i <= b; i++) {
			if (!isPrime[i]) continue;
			
			if (isIncluded(i, d)) answer++;
		}
		
		System.out.println(answer);
		
	}
	
	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13) System.in.read();
		return n;
	}
	
	static boolean[] getEuclead(int n) {
		boolean[] isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		
		for (int i = 2; i <= n; i++) {
			if (!isPrime[i]) continue;
			
			int num = i + i;
			while (num <= n) {
				isPrime[num] = false;
				num += i;
			}
		}
		
		return isPrime;
	}
	
	static boolean isIncluded(int num, int d) {
		while (num > 0) {
			if (num % 10 == d) return true;
			num /= 10;
		}
		return false;
	}
	
}
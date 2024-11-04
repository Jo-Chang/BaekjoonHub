import java.io.*;

class Main {
	
	static final int MOD = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {

		int m = readInt();
		long sum = 0;
		
		for (int i = 0; i < m; i++) {
			int n = readInt(), s = readInt();
			sum += getExpectation(n, s);
			sum %= MOD;
		}
		
		System.out.println(sum);
	}
	
	static int readInt() throws IOException {
		int input, num = System.in.read() & 15;
		
		while ((input = System.in.read()) > 32) {
			num = (num << 3) + (num << 1) + (input & 15);
		}
		
		return num;
	}
	
	static int getExpectation(int n, int s) {
		int gcd = getGCD(n, s);
		
		n /= gcd;
		s /= gcd;
		
		return getModuloNumber(n, s);
	}
	
	static int getGCD(int n1, int n2) {
		int gcd = n2;
		
		while (n1 % n2 > 0) {
			gcd = n1 % n2;
			n1 = n2;
			n2 = gcd;
		}
		
		return gcd;
	}
	
	static int getModuloNumber(int n, int s) {
		if (n == 1) return s;
		return (int) (getReversedModulo(n) * s % MOD);
	}
	
	static long getReversedModulo(int n) {
		return pow(n, MOD - 2);
	}
	
	static long pow(long n, int e) {
		if (e == 1) return n;
		
		long num = pow(n, e / 2);
	
		return num * num % MOD * (e % 2 == 0 ? 1 : n) % MOD;
	}
	
}
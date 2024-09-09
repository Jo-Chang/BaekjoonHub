import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	final static long MOD = 1_000_000_007;
	static Map<Long, Long> memoizationMap = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
	
		Scanner sc = new Scanner(System.in);
		Long n = sc.nextLong();
		sc.close();
		
//		System.out.println(fibonacci1(n));
//		System.out.println(fibonacci2(n));
//		System.out.println(fibonacci3(n));
//		System.out.println(fibonacci4(n));
		System.out.println(fibonacci5(n));
		
	}
	
	// basic recursive fibonacci
	// O(M^n)
	static long fibonacci1(long n) {
		if (n == 1l) 
			return 1;
		else if (n == 0l) 
			return 0;
		else 
			return (fibonacci1(n - 1) + fibonacci1(n - 2)) % MOD; 
	}
	
	// call previous fibonacci number
	// O(n)
	static long fibonacci2(long n) {
		long a = 0, b = 1;
		
		for (long i = 2; i <= n; i++) {
			long tmp = (a + b) % MOD;
			a = b;
			b = tmp;
		}
		
		return b;
	}
	
	// matrix exponentiation 
	// O(log_n)
	static int fibonacci3(long n) {
		
//		var a = getMatrixExponentiation(n);
//		System.out.println(String.format("| %d, %d |\n", a[0][0], a[0][1]));
//		System.out.println(String.format("| %d, %d |\n", a[1][0], a[1][1]));
		
		return (int)getMatrixExponentiation(n)[0][1];
	}
	
	static long[][] getMatrixExponentiation(long n) {
		if (n == 1l) return new long[][] {{1, 1}, {1, 0}};
		
		long[][] mtx1 = getMatrixExponentiation(n / 2);
		long[][] mtx2 = getMatrixExponentiation(n - n/2);
		
		long[][] numbers = new long[2][2];
		
		numbers[0][0] = (mtx1[0][0] * mtx2[0][0]) % MOD + (mtx1[0][1] * mtx2[1][0]) % MOD;
		numbers[0][1] = (mtx1[0][0] * mtx2[0][1]) % MOD + (mtx1[0][1] * mtx2[1][1]) % MOD;
		numbers[1][0] = (mtx1[1][0] * mtx2[0][0]) % MOD + (mtx1[1][1] * mtx2[1][0]) % MOD;
		numbers[1][1] = (mtx1[1][0] * mtx2[0][1]) % MOD + (mtx1[1][1] * mtx2[1][1]) % MOD;
		numbers[1][1] = (mtx1[1][0] * mtx2[0][1]) % MOD + (mtx1[1][1] * mtx2[1][1]) % MOD;
		
		numbers[0][0] %= MOD;
		numbers[0][1] %= MOD;
		numbers[1][0] %= MOD;
		numbers[1][1] %= MOD;
		
		return new long[][] 
			{
				{numbers[0][0], numbers[0][1]},
				{numbers[1][0], numbers[1][1]}
			};
	}
	
	// fast doubling
	// O(log_n)
	static int fibonacci4(long n) {
		if (n == 1 || n == 2) return 1;
		else if (n == 0) return 0;
		
		long num1 = fibonacci4(n / 2);
		long num2 = fibonacci4(n / 2 + 1);
		
		if (n % 2 == 0) return (int)((num1 * (2*num2 - num1)) % MOD);
		else return (int)((num2 * num2 + num1 * num1) % MOD);
	}
	
	// fast doubling (memoization)
	static long fibonacci5(long n) {
		if (n == 1 || n == 2) return 1;
		else if (n == 0) return 0;
		else if (memoizationMap.containsKey(n)) return memoizationMap.get(n);
		
		long num1 = n / 2;
		long num2 = n / 2 + 1;
		
		long res1 = fibonacci5(num1);
		memoizationMap.put(num1, res1);
	
		long res2 = fibonacci5(num2);
		memoizationMap.put(num2, res2);
		
		long result = 0;
		if (n % 2 == 0) {
			result = res1 * (res2 * 2 - res1) % MOD;
		}
		else {
			result = (res2 * res2) % MOD + (res1 * res1) % MOD;
		}
		return (result + MOD) % MOD;
	}
}
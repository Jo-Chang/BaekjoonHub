import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger[] fiboNums = new BigInteger[n + 1];
		
		fiboNums[0] = BigInteger.valueOf(0);
		fiboNums[1] = BigInteger.valueOf(1);
		if (n > 1) fiboNums[2] = BigInteger.valueOf(1);
		
		for (int i = 3; i <= n; i++) {
			fiboNums[i] = fiboNums[i - 1].add(fiboNums[i - 2]);
		}
		
		System.out.println(fiboNums[n]);
		
	}
	
}
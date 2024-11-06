import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		
		int p = readInt(), a = readInt(), b = readInt(), c = readInt(), d = readInt(), n = readInt();
		double answer = 0, rangeMax = Double.MIN_VALUE;
		
		for (int i = 1; i <= n; i++) {
			double value = p * (Math.sin(a * i + b) + Math.cos(c * i + d) + 2);
			if (value > rangeMax) 
				rangeMax = value;
			answer = Math.max(answer, rangeMax - value);
		}
		
		System.out.println(answer);
	}
	
	static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 11 || c == 13) System.in.read();
		return n;
	}
	
}
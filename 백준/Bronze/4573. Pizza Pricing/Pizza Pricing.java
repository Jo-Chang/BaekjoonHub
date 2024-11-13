import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		int n, tc = 1;
		while ((n = read()) > 0) {
			
			double maxPricePerDiameter = 0;
			int maxDiameter = 0;
			for (int i = 0; i < n; i++) {
				int diameter = read(), price = read();
				double pricePerDiameter = (double) diameter * diameter / price;
				if (pricePerDiameter > maxPricePerDiameter) {
					maxPricePerDiameter = pricePerDiameter;
					maxDiameter = diameter;
				}
			}
			sb.append(String.format("Menu %d: %d\n", tc++, maxDiameter));
		}
		
		System.out.println(sb);
		
	}
	
	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13) System.in.read();
		return n;
	}
	
}
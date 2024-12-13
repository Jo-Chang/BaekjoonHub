import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		int n = read(), cnt = 1;
		
		while (n >= 10) {
			sb.append(n % 10);
			n /= 10;
			if (cnt++ % 3 == 0) sb.append(","); 
		}
		sb.append(n);
		
		System.out.println(sb.reverse());
		
	}
	
	static int read() throws IOException {
		int c, n = 0;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13) System.in.read();
		return n;
	}
	
}
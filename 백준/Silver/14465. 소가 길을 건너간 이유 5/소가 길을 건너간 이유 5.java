import java.io.*;
import java.util.*;

public class Main {
	
	static int n, k;
	public static void main(String[] args) throws IOException {
		
		n = read(); 
		k = read();
		int b = read(), cnt = 0;
		
		int[] wrongs = new int[b + 2];
		wrongs[0] = 1; 
		wrongs[b + 1] = n;
		for (int i = 1; i <= b; i++) {
			wrongs[i] = read();
		}
		
		Arrays.sort(wrongs);
		
		loop:
		while (true) {
			for (int i = 1; i <= b + 1 - cnt; i++) {
				if (wrongs[i + cnt] - wrongs[i - 1] >= k) 
					break loop;
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
		
	}
	
	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13) System.in.read();
		return n;
	}
	
}
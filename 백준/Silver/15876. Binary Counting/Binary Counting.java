import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < 5 * n; i++) {
			sBuffer.append(Integer.toBinaryString(i));
		}
		
		for (int i = 0; i < 5; i++) {
			sb.append(sBuffer.charAt(k - 1 + i * n)).append(" ");
		}
		
		System.out.println(sb);
	}
	
}
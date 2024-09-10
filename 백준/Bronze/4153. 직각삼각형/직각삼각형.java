import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	final static int MAX = 8;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
				
			if (a == 0 && b == 0 && c == 0) break;
			
			int max = Math.max(a, Math.max(b, c));
			int powerSum = a * a + b * b + c * c;
			if (powerSum - max * max == max * max) sb.append("right\n");
			else sb.append("wrong\n");
		}
		
		System.out.println(sb);
		
	}
	
}
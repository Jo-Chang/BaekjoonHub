import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int gcd = getGreatestCommondDivision(a, b);
		sb.append(gcd).append("\n");
		sb.append(a * b / gcd).append("\n");
		
		System.out.println(sb);
	}
	
	static int getGreatestCommondDivision(int a, int b) {
		for (int i = Math.min(a, b); i > 0; i--) {
			if (a % i == 0 && b % i == 0) return i;
		}
		
		return 1;
	}
}
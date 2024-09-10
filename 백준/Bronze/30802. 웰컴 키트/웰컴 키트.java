import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	final static int MAX = 8;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[] sizes = new int[6];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			sizes[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int shirtsBundles = 0;
		for (int i = 0; i < 6; i++) {
			shirtsBundles += sizes[i] / t + ((sizes[i] % t > 0)? 1 : 0);
		}
		
		sb.append(shirtsBundles).append("\n");
		sb.append(n / p).append(" ").append(n % p);
		
		System.out.println(sb);
	}
	
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int childrenNum = 0;
			for (int i = 0; i < n; i++) {
				int candy = Integer.parseInt(st.nextToken());
				childrenNum += candy / k;
			}
			
			sb.append(childrenNum).append("\n");
		}
		
		System.out.println(sb);
	}
	
}
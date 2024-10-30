import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		while (tc-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int sum = 0, winner = 0, winningCount = 0;
			boolean isSame = false;
			
			for (int i = 1; i <= n; i++) {
				int num = Integer.parseInt(br.readLine());
				sum += num;
				if (num > winningCount) {
					isSame = false;
					winningCount = num;
					winner = i;
				} else if (num == winningCount) {
					isSame = true;
				}
			}
			
			if (isSame) sb.append("no winner\n");
			else {
				if (winningCount > sum / 2) sb.append("majority ");
				else sb.append("minority ");
				
				sb.append("winner ").append(winner).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
}
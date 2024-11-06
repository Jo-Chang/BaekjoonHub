import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input;
		while (!(input = br.readLine()).equals("#")) {
			
			String[] inputs = input.split(" ");
			int len = inputs[0].length(), b = 0, g = 0, w = 0;
			boolean[][] visit = new boolean[2][len];
			Map<Character, Integer> map = new HashMap<>();
			
			for (int i = 0; i < len; i++) {
				char ch1 = inputs[0].charAt(i);
				char ch2 = inputs[1].charAt(i);
				
				if (ch1 == ch2) {
					b++;
					visit[0][i] = visit[1][i] = true;
				} else {
					if (i > 0) {
						char ch3 = inputs[0].charAt(i - 1);
						char ch4 = inputs[1].charAt(i - 1);
						if (ch3 == ch2 && !visit[0][i - 1] && !visit[1][i]) {
							g++;
							visit[0][i - 1] = visit[1][i] = true;
						}
						if (ch1 == ch4 && !visit[0][i] && ! visit[1][i - 1]) {
							g++;
							visit[0][i] = visit[1][i - 1] = true;
						}
					} 
				}
			}
			
			for (int i = 0; i < len; i++) {
				if (visit[1][i]) continue;
				
				char ch2 = inputs[1].charAt(i);
				
				for (int j = 0; j < len; j++) {
					if (visit[0][j]) continue;
					
					char ch1 = inputs[0].charAt(j);
					
					if (ch1 == ch2) {
						w++;
						visit[0][j] = visit[1][i] = true;
					}
				}
			}
			
			sb.append(String.format("%s: %d black, %d grey, %d white\n",
						inputs[1], b, g, w
					));
			
		}
		
		System.out.println(sb);
		
	}
	
}
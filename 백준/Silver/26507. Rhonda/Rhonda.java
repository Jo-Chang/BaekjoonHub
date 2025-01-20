import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		final int GRID = 10;
		int layerN = Integer.parseInt(br.readLine());
		int[][][] layer = new int[layerN][GRID][GRID];
		
		for (int i = 0; i < layerN; i++) {
			for (int j = 0; j < GRID; j++) {
				String input = br.readLine();
				
				for (int k = 0; k < GRID; k++) layer[i][j][k] = input.charAt(k) - '0';
			}
			br.readLine();
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int[][] resultLayer = new int[GRID][GRID];
			while (st.hasMoreTokens()) {
				int grid = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < GRID; j++) {
					for (int k = 0; k < GRID; k++) {
						resultLayer[j][k] += layer[grid][j][k];
					}
				}
			}
			
			for (int j = 0; j < GRID; j++) {
				for (int k = 0; k < GRID; k++) {
					sb.append(String.format("%02d ", resultLayer[j][k]));
				}
				sb.append("\n");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
	
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] numbers = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		recursiveCombinations(new int[m], numbers, m, 0);
		
		System.out.println(sb);
	}
	
	static void recursiveCombinations(int[] combination, int[] numbers, int c, int depth) {
		if (depth == c) {
			for (int num : combination) {
//				System.out.printf("%d ", num);
				sb.append(num).append(" ");
			}
//			System.out.println();
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0) continue;
			
			combination[depth] = numbers[i];
			numbers[i] = 0;
			
			recursiveCombinations(combination, numbers, c, depth + 1);
			
			numbers[i] = combination[depth];
		}
	}

}
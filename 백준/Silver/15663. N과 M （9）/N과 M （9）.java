import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static Set<String> combinations = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		int[] numbers = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		addDistinctCombination(numbers, new int[m], 0);
		
		System.out.println(sb);
		
	}
	
	static void addDistinctCombination(int[] arr, int[] comb, int depth) {
		if (depth == comb.length) {
			String combination = myToString(comb);
			
			if (!combinations.contains(combination)) {
				combinations.add(combination);
				
				for (int i = 0; i < comb.length; i++) {
					sb.append(comb[i]).append(" ");
				}
				
				sb.append("\n");
			}
			
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) continue;
			
			comb[depth] = arr[i];
			arr[i] = 0;
			addDistinctCombination(arr, comb, depth + 1);
			arr[i] = comb[depth];
		}
	}
	
	static String myToString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		
		for (int num : arr) {
			sb.append(num).append(" ");
		}
		
		return sb.toString();
	}
	
}
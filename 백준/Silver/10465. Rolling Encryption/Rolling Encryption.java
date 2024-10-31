import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		int[] frequency = new int[26];
		for (int i = 0; i < n; i++) {
			frequency[input.charAt(i) - 'a']++;
			sb.append(input.charAt(i));
		}

		for (int i = n; i < input.length(); i++) {
			char nextChar = (char) (input.charAt(i) + getMaximumIndex(frequency) + 1);
			if (nextChar > 'z') nextChar -= 26;
			sb.append(nextChar);
			
			frequency[input.charAt(i - n) - 'a']--;
			frequency[input.charAt(i) - 'a']++;
		}
		
		System.out.println(sb);
		
	}
	
	static int getMaximumIndex(int[] arr) {
		int idx = 0;
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[idx]) idx = i;
		}
		
		return idx;
	}
}
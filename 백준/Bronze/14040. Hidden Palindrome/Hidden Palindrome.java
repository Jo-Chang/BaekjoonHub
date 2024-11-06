import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int answer = 0, len = input.length();

		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				answer = Math.max(answer, getPalindromeLength(input.substring(i, j + 1)));
			}
		}
		
		System.out.println(answer);
		
	}
	
	static int getPalindromeLength(String str) {
		
		int len = str.length();

		for (int i = 0; i < len / 2; i++) {
			if (str.charAt(i) != str.charAt(len - i - 1)) return 0;
		}
		
		return len;
		
	}
	
}
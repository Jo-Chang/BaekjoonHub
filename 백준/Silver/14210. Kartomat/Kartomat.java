import java.io.*;
import java.util.*;

class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		String[] destinations = new String[n];
		for (int i = 0; i < n; i++) {
			destinations[i] = br.readLine();
		}
		
		String typedWord = br.readLine();
		
		printKeyboard(destinations, typedWord);
		
		System.out.println(sb);
	}
	
	static void printKeyboard(String[] destinations, String word) {
		char[] keyboard = new char[32];
		Arrays.fill(keyboard, '*');
		int len = word.length();
		
		for (String dest : destinations) {
			if (dest.startsWith(word)) {
				char ch = dest.charAt(len);
				keyboard[ch - 'A' + 3] = ch;
			}
		}
		
		for (int i = 0; i < keyboard.length; i++) {
			sb.append(keyboard[i]);
			
			if ((i + 1) % 8 == 0) sb.append("\n");
		}
	}
	
}
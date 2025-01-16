import java.io.*;
import java.util.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		char[] charSet = new char[26];
		
		while (sc.hasNextLine()) {
			String input = sc.nextLine();
			
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				
				if ('a' <= ch && ch <= 'z') {
					charSet[ch - 'a']++;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < 26; i++) {
			if (charSet[i] > max) {
				sb.setLength(0);
				sb.append((char)('a' + i));
				max = charSet[i];
			} else if (charSet[i] == max) {
				sb.append((char)('a' + i));
			}
		}
		
		System.out.println(sb);
		
	}
	
}
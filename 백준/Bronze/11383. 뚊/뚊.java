import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		String ans = "Eyfa";
		String[] words = new String[n];
		
		for (int i = 0; i < n; i++) words[i] = br.readLine();
		for (int i = 0; i < n; i++) {
			if (!isEyfa(words[i], br.readLine())) {
				ans = "Not Eyfa";
				break;
			}
		}
		
		System.out.println(ans);
		
	}
	
	static boolean isEyfa(String origin, String doubled) {
		if (doubled.length() != origin.length() * 2) return false;
		
		for (int i = 0; i < origin.length(); i++) {
			char ch = origin.charAt(i);
			
			if (ch != doubled.charAt(2 * i) || ch != doubled.charAt(2 * i + 1))
				return false;
		}
		
		return true;
	}
	
}
import java.io.*;
import java.util.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		String[] words = new String[n];
		int[][] charSet = new int[m][26];
		
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
			for (int j = 0; j < m; j++) {
				charSet[j][words[i].charAt(j) - 'A']++;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < m; i++) {
			char ch = '-';
			int max = 0;
			
			for (int j = 0; j < 26; j++) {
				if (charSet[i][j] > max) {
					ch = (char) ('A' + j);
					max = charSet[i][j];
				}
			}
			
			sb.append(ch);
		}
		
		for (int i = 0; i < n; i++) {
			ans += getHammingDistance(sb.toString(), words[i]);
		}
		
		System.out.println(sb.toString());
		System.out.println(ans);
		
	}
	
	static int getHammingDistance(String str1, String str2) {
		int res = 0;
		
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) res++;
		}
		
		return res;
	}
	
}
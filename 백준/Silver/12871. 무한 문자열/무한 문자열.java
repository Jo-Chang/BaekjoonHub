import java.io.*;
import java.util.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine(), str2 = br.readLine();
		
		System.out.println(isSameInfiniteString(str1, str2));
		
	}
	
	static int isSameInfiniteString(String s1, String s2) {
		String strL = "", strS = "";
		StringBuffer sb1 = new StringBuffer(), sb2 = new StringBuffer();
		
		if (s1.length() < s2.length()) {
			strL = s2;
			strS = s1;
		} else {
			strL = s1;
			strS = s2;
		}
		
		int lenL = strL.length(), lenS = strS.length();
		
		for (int i = 0; i < lenL; i++) sb1.append(strS);
		for (int i = 0; i < lenS; i++) sb2.append(strL);
		
		return sb1.toString().equals(sb2.toString()) ? 1 : 0;
	}
	
}
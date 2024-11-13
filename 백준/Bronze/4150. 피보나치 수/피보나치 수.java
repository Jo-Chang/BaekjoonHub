import java.io.*;
import java.util.*;

class Main {
	
	static String[] fiboNums = new String[5001];
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibonacci(n));
		
	}
	
	static String fibonacci(int n) {
		if (fiboNums[n] != null) return fiboNums[n];
		if (n == 1 || n == 2) return fiboNums[n] = "1";
		return fiboNums[n] = stringSum(fibonacci(n - 1), fibonacci(n - 2));
	}
	
	static String stringSum(String n1, String n2) {
		StringBuffer sb = new StringBuffer();
		boolean isOver = false;
		int idx = 0, len1 = n1.length(), len2 = n2.length();

		while (idx < len1 && idx < len2) {
			char newChar = (char) (n1.charAt(len1 - 1 - idx) + n2.charAt(len2 - 1 - idx) - '0');
			if (isOver) {
				newChar++;
				isOver = false;
			}
			if (newChar > '9') {
				newChar -= 10;
				isOver = true;
			}
			sb.append(String.valueOf(newChar));
			idx++;
		}
		
		while (idx < len1) {
			char newChar = n1.charAt(len1 - 1 - idx);
			if (isOver) {
				newChar++;
				isOver = false;
			}
			if (newChar > '9') {
				newChar -= 10;
				isOver = true;
			}
			sb.append(String.valueOf(newChar));
			idx++;
		}
		
		while (idx < len2) {
			char newChar = n2.charAt(len2 - 1 - idx);
			if (isOver) {
				newChar++;
				isOver = false;
			}
			if (newChar > '9') {
				newChar -= 10;
				isOver = true;
			}
			sb.append(String.valueOf(newChar));
			idx++;
		}
		
		if (isOver) sb.append("1");
		
		return sb.reverse().toString();
	}
	
}
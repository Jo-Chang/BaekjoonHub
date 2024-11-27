import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int len = s.length(), x = 0, y = 0;
		
		for (int i = 0; i < len; i++) {
			int num = s.charAt(len - 1 - i) - '0', pow = (int) Math.pow(2, i);
			x += num % 2 * pow;
			y += num / 2 * pow;
		}
		
		System.out.printf("%d %d %d", len, x, y);
		
	}
	
}
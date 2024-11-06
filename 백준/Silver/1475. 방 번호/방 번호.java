import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		int[] numberSet = new int[10];
		int answer = 0;
		
		for (int i = 0; i < number.length(); i++) {
			numberSet[number.charAt(i) - '0']++;
		}
		
		int sum = numberSet[6] + numberSet[9];
		numberSet[6] = sum / 2;
		numberSet[9] = sum - numberSet[6];
		
		for (int i = 0; i < 10; i++) {
			answer = Math.max(answer, numberSet[i]);
		}
		
		System.out.println(answer);
		
	}
	
	static int readInt() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
}
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int answer = 0;
		
		loop:
		for (int i = input.length(); i > 0; i--) {
			if (i % 2 != 0) continue;
			
			for (int j = 0; j <= input.length() - i; j++) {
				if (isCriString(input.substring(j, j + i))) {
					answer = i;
					break loop;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean isCriString(String str) {
		int left = 0, right = 0;
		int half = str.length() / 2;
		
		for (int i = 0; i < half; i++) {
			left += str.charAt(i) - '0';
			right += str.charAt(half + i) - '0';
		}
		
		return left == right;
	}
	
}
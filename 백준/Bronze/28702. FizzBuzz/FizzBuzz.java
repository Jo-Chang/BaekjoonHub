import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

	final static int COUNT = 3;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int result = 0;
		for (int i = 0; i < COUNT; i++) {
			String str = br.readLine();
			if (isNumber(str)) result = Integer.parseInt(str) + COUNT - i;
		}
		
		System.out.println(getFizzBuzz(result));
	}
	
	static boolean isNumber(String str) {
		if (str.contains("Fizz")) return false;
		else if (str.contains("Buzz")) return false;
		else return true;
	}
	
	static String getFizzBuzz(int num) {
		if (num % 3 == 0 && num % 5 == 0) return "FizzBuzz";
		else if (num % 3 == 0) return "Fizz";
		else if (num % 5 == 0) return "Buzz";
		else return String.valueOf(num);
	}
	
}
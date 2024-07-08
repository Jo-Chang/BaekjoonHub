import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		new Main().sol();
	}

	void sol() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = new String[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = br.readLine();
		}
		
		int answer = 0;
		for (int i = 0; i < 3; i++) {
			if (simpleIsNumber(arr[i])) {
				answer = Integer.parseInt(arr[i]) + 3 - i;
				break;
			}
		}

		System.out.println(getFizzBuzz(answer));
	}

	boolean simpleIsNumber(String str) {
		return '0' <= str.charAt(0) && str.charAt(0) <= '9';
	}

	String getFizzBuzz(int n) {
		String result = "";

		if (n % 3 == 0) result += "Fizz";
		if (n % 5 == 0) result += "Buzz";

		if (result.isEmpty()) return result + n;
		else return result;
	}
}
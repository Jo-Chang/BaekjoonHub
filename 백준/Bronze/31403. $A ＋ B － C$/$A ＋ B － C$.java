import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		new Main().sol();
	}

	void sol() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		br.close();

		System.out.println(calculate(a, b, c));
		System.out.println(calculateJavaScript(a, b, c));
	}

	int calculate(int a, int b, int c) {
		return a + b - c;
	}

	int calculateJavaScript(int a, int b, int c) {
		return Integer.parseInt(a + "" + b) - c;
	}
}
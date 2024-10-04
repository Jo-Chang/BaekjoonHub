import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		sb.append(printDouble(getMean(arr))).append("\n");
		sb.append(printDouble(getMedian(arr))).append("\n");
		
		System.out.println(sb);
	}
	
	static float getMean(int[] arr) {
		double result = 0;
		int n = arr.length;
		
		for (int i = 0; i < n; i++) {
			result += arr[i];
		}
		
		return (float)result / n;
	}
	
	static float getMedian(int[] arr) {
		int n = arr.length;
		
		Arrays.sort(arr);
		
		if (n % 2 != 0) return (float)arr[n / 2];
		else return ((float)arr[n / 2] + arr[n / 2 - 1]) / 2;
	}
	
	static String printDouble(float f) {
		return String.format("%.6f", f);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		boolean result = countedBubbleSort(arr, k);
		
		if (!result) {
			for (int i = 0; i < n; i++) sb.append(arr[i]).append(" ");
		} else {
			sb.append(-1);
		}
		System.out.println(sb);
	}
	
	static boolean countedBubbleSort(int[] arr, int k) {
		int count = 0;
		
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
					
					if (++count == k) return false;
				}
			}
		}
		
		return true;
	}
	
}
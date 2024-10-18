import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] factoryFrequencies = new int[n];
		for (int i = 0; i < n; i++) {
			factoryFrequencies[i] = Integer.parseInt(st.nextToken());
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int requiredFrequency = Integer.parseInt(st.nextToken());
			int diff = requiredFrequency - factoryFrequencies[i];
			map.put(diff, map.getOrDefault(diff, 0) + 1);
		}
		
		int answer = 0;
		for (int num : map.values()) {
			answer = Math.max(answer, num);
		}
		
		System.out.println(answer);
	}
	
}
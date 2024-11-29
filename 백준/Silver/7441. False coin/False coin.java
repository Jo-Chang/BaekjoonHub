import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), answer = 0;
		int[] coins = new int[n + 1];
		
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken());
			int[] left = new int[p], right = new int[p];
			for (int i = 0; i < p; i++) left[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < p; i++) right[i] = Integer.parseInt(st.nextToken());
			
			String result = br.readLine();
			
			if (result.equals("=")) {
				for (int i = 0; i < p; i++) coins[left[i]] = coins[right[i]] = 1;
			} else {
				for (int i = 0; i < p; i++) {
					if (coins[left[i]] < 1) coins[left[i]]--;
					if (coins[right[i]] < 1) coins[right[i]]--;
				}
			}
		}
		
		// case1: 0이 단 한개
		int zeroCnt = 0;
		for (int i = 1; i <= n; i++) {
			if (coins[i] == 0) {
				zeroCnt++;
				answer = i;
			} else if (coins[i] < 0) {
				answer = 0;
				break;
			}
		}
		if (zeroCnt != 1) answer = 0;
		
		// case2: 제일 낮은 수 (없으면, 정답은 0)
		if (answer == 0) {
			int minIdx = 0;
			for (int i = 1; i <= n; i++) {
				if (coins[minIdx] > coins[i]) {
					answer = i;
					minIdx = i;
				}
				else if (coins[minIdx] == coins[i]) answer = 0;
			}
		}
		
		System.out.println(answer);
		
	}
	
}
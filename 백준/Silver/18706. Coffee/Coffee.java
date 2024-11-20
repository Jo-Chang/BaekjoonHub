import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int deliveryFee = 100 / p;
			
			Map<String, int[]> coffees = new HashMap<>(); 
			
			for (int i = 0; i < c; i++) {
				st = new StringTokenizer(br.readLine());
				
				coffees.put(st.nextToken(), new int[] {
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())
				});
			}
			for (int i = 0; i < p; i++) {
				st = new StringTokenizer(br.readLine());
				
				String name = st.nextToken(), size = st.nextToken(), coffee = st.nextToken();
				int sizeIndex = -1;
				switch (size) {
				case "small":
					sizeIndex = 0;
					break;
				case "medium":
					sizeIndex = 1;
					break;
				case "large":
					sizeIndex = 2;
					break;
				}
				
				int cost = coffees.get(coffee)[sizeIndex] + deliveryFee;
				if (cost % 5 == 1) cost--;
				if (cost % 5 == 4) cost++;
				
				sb.append(String.format("%s %d\n", name, cost));
			}
			
		}
		
		System.out.println(sb);
		
	}
	
}
import java.util.*;

class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int testCase = sc.nextInt();
		
		for (int tc = 1; tc <= testCase; tc++) {
			int c = sc.nextInt(), p = sc.nextInt(), deliveryFee = 100 / p;
			Map<String, int[]> coffees = new HashMap<>(); 
			
			for (int i = 0; i < c; i++) {
				String coffee = sc.next();
				
				int[] fee = new int[3];
				fee[0] = sc.nextInt();
				fee[1] = sc.nextInt();
				fee[2] = sc.nextInt();
				
				coffees.put(coffee, fee);
			}
			for (int i = 0; i < p; i++) {
				String name = sc.next(), size = sc.next(), coffee = sc.next();
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
import java.io.*;
import java.util.*;

class Main {
	
	static class Location {
		int r, c;
		
		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static List<Location> homes, stores;
	static int n, m;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		homes = new ArrayList<>();
		stores = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				String input = st.nextToken();
				switch (input) {
				case "1":
					homes.add(new Location(i, j));
					break;
				case "2":
					stores.add(new Location(i, j));
					break;
				default:
				}
			}
		}
		
		System.out.println(getMinimalChickenDistance());
	}
	
	static int getMinimalChickenDistance() {
		List<Integer> chickenDistances = new ArrayList<>();
		return chooseStores(chickenDistances, new Location[m], 0, 0);
	}
	
	static int chooseStores(List<Integer> list, Location[] loc, int depth, int index) {

		if (depth == m) {
			return getChickenDistance(loc);
		}
		
		int result = Integer.MAX_VALUE;
		
		for (int i = index; i < stores.size(); i++) {
			loc[depth] = new Location(stores.get(i).r, stores.get(i).c);
			result = Math.min(result, chooseStores(list, loc, depth + 1, i + 1));
		}
		
		return result;
		
	}
	
	static int getChickenDistance(Location[] loc) {

		int totalDistance = 0;
		
		for (int i = 0; i < homes.size(); i++) {
			
			Location home = homes.get(i);
			int distance = Integer.MAX_VALUE;
			
			for (int j = 0; j < loc.length; j++) {
				distance = Math.min(distance, 
						Math.abs(home.r - loc[j].r) +
						Math.abs(home.c - loc[j].c)
						);
			}
			
			totalDistance += distance;
		}
		
		return totalDistance;
		
	}
	
}
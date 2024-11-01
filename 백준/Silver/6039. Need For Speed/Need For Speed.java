import java.io.*;
import java.util.*;

class Main {
	
	static class Gear {
		
		int force, mass, index;

		Gear(int force, int mass, int index) {
			this.force = force;
			this.mass = mass;
			this.index = index;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		int f = readInt();
		int m = readInt();
		int n = readInt();
		
		Queue<Gear> q = new PriorityQueue<>(
				new Comparator<Gear>() {
					@Override
					public int compare(Gear g1, Gear g2) {
						if (g1.force * g2.mass != g2.force * g1.mass)
							return g2.force * g1.mass - g1.force * g2.mass;
						else return g1.mass - g2.mass;
					}}
				);
		
		for (int i = 0; i < n; i++) {
			int force = readInt();
			int mass = readInt();
			
			q.add(new Gear(force, mass, i + 1));
		}
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			
			Gear g = q.poll();
			
			if (f * g.mass >= g.force * m) break;
			
			f += g.force;
			m += g.mass;
			list.add(g.index);
			
		}
		
		if (list.isEmpty()) sb.append("NONE");
		
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static int readInt() throws IOException {

		int input, num = System.in.read() & 15;
		
		while ((input = System.in.read()) > 32) 
			num = (num << 3) + (num << 1) + (input & 15);
		
		return num;
		
	}
	
}
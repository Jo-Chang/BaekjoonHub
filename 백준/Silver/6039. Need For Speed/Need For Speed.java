import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		int f = readInt();
		int m = readInt();
		int n = readInt();
		
		int[] forces = new int[n];
		int[] masses = new int[n];
		
		for (int i = 0; i < n; i++) {
			forces[i] = readInt();
			masses[i] = readInt();
		}
		
		double maxAcceleration = (double) f / m;
		int maxMass = m;
		boolean[] maxBits = new boolean[n], bits = new boolean[n];
		
		for (int i = 0; i < (1 << n); i++) {
			
			setBit(bits, i);
			
			int force = f;
			int mass = m;
			for (int j = 0; j < n; j++) {
				if (!bits[j]) continue;
				
				force += forces[j];
				mass += masses[j];
			}
			
			double acceleration = (double) force / mass;
			
			if (acceleration > maxAcceleration) {
				maxAcceleration = acceleration;
				maxMass = mass;
				maxBits = bits.clone();
			} else if (acceleration == maxAcceleration) {
				if (mass < maxMass) {
					maxAcceleration = acceleration;
					maxMass = mass;
					maxBits = bits.clone();
				}
			}
			
		}
		
		for (int i = 0; i < n; i++) {
			if (maxBits[i]) sb.append(i + 1).append("\n");
		}
		if (sb.length() == 0) sb.append("NONE");
		
		System.out.println(sb);
		
	}
	
	static int readInt() throws IOException {

		int input, num = System.in.read() & 15;
		
		while ((input = System.in.read()) > 32) 
			num = (num << 3) + (num << 1) + (input & 15);
		
		return num;
		
	}
	
	static void setBit(boolean[] bits, int num) {
		int idx = 0;
		
		for (int i = 0; i < bits.length; i++) {
			if (num % 2 == 1) bits[idx++] = true;
			else bits[idx++] = false;
			num /= 2;
		}
	}
	
}
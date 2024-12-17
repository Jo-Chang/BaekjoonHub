public class Main {
	
	static char[][] arr;
	
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		int n = read();
		int[] order = new int[n];
		
		for (int i = 0; i < n; i++) {
			int num = read(), cnt = 0;
			
			for (int j = 0; j < n; j++) {
				if (order[j] != 0) continue;
				if (num == cnt) {
					order[j] = i + 1;
					break;
				}
				cnt++;
			}
		}
		
		for (int i = 0; i < n; i++) sb.append(order[i]).append(" ");
		
		System.out.println(sb);
	}
	
	static int read() throws Exception {
		int c, n = 0;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
}
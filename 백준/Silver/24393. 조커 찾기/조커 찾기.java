import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		int n = read(), answer = 1;
		
		for (int i = 0; i < n; i++) {
			int num, sum = 0, cnt = 1, newAnswer = answer;
			boolean b = false;

			if (newAnswer > 13) newAnswer -= 13;
			
			while (sum < 27) {
				num = read();
				sum += num;
				
				if (!b) {
					
					if (cnt % 2 != 0 && answer >= 14){
						if (newAnswer > num) newAnswer -= num;
						else {
							answer = sum - num + newAnswer;
							b = true;
						}
					} else if (cnt % 2 == 0 && answer < 14) {
						if (newAnswer > num) newAnswer -= num;
						else {
							answer = sum - num + newAnswer;
							b = true;
						}
					} 
					
					cnt++;
				}
			}
		}
		
		System.out.println(answer);
		
	}
	
	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13) System.in.read();
		return n;
	}
	
}
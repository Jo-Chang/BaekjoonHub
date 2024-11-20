import java.io.*;

class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] inputs = new String[n];
		
		for (int i = 0; i < n; i++) {
			inputs[i] = br.readLine();
		}
		
		System.out.println(isCorrect(inputs));
		
	}
		
	static int isCorrect(String[] inputs) {
		int n = inputs.length;
		
		for (int i = 0; i < n; i++) {
			int cntCol = 0, cntRow = 0, cntBlackCol = 0, cntBlackRow = 0;
			char lastCol = 'a', lastRow = 'a';
			
			for (int j = 0; j < n; j++) {
				
				char ch1 = inputs[i].charAt(j), ch2 = inputs[j].charAt(i);
				
				if (ch1 == 'B') cntBlackCol++;
				if (ch2 == 'B') cntBlackRow++;
				
				if (ch1 != lastCol) {
					lastCol = ch1;
					cntCol = 1;
				} else if (cntCol == 2) {
					return 0;
				} else {
					cntCol++;
				}
				
				if (ch2 != lastRow) {
					lastRow = ch2;
					cntRow = 1;
				} else if (cntRow == 2) {
					return 0;
				} else {
					cntRow++;
				}
				
			}
			
			if (cntBlackCol != n / 2 || cntBlackRow != n / 2) return 0;
			
		}
		
		return 1;
	}
	
}
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), answer = 1;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num, sum = 0, cnt = 1, newAnswer = answer;

			if (newAnswer > 13) newAnswer -= 13;
			
			while (sum < 27) {
				num = Integer.parseInt(st.nextToken());
				sum += num;
				
				if (cnt % 2 != 0 && answer >= 14){
					if (newAnswer > num) newAnswer -= num;
					else {
						newAnswer = sum - num + newAnswer;
						break;
					}
				} else if (cnt % 2 == 0 && answer < 14) {
					if (newAnswer > num) newAnswer -= num;
					else {
						newAnswer = sum - num + newAnswer;
						break;
					}
				} 
				cnt++;
			}
			
			answer = newAnswer;
		}
		
		System.out.println(answer);
		
	}
	
}
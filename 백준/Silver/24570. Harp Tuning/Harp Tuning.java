import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		
		int lastIndex = 0;
		int num = 0;
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			
			if (ch == '+') {
				sb.append(input.substring(lastIndex, i))
				.append(" tighten ");
			} else if (ch == '-') {
				sb.append(input.substring(lastIndex, i))
				.append(" loosen ");
			} else if ('0' <= ch && ch <= '9') {
				num = num * 10 + ch - '0';
			} else if (num > 0) {
				sb.append(num).append("\n");
				num = 0;
				lastIndex = i;
			}
		}
		
		sb.append(num); // 마지막 튜닝 수  
		
		System.out.println(sb);
	}
	
}
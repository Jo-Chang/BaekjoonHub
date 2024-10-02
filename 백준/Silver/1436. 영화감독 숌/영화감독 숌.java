import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int number = 666;
		while (cnt < n) {
			if (String.valueOf(number).contains("666")) cnt++;
			number++;
		}
		
		System.out.println(number - 1);
	}
	
}
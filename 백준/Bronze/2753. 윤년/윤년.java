import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int year = Integer.parseInt(br.readLine());
		br.close();
		
		System.out.println(((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) ? 1 : 0);
	}
	
}
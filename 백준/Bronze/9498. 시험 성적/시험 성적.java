import java.io.IOException;
import java.util.Scanner;

class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int score = sc.nextInt();
		String result = "";
		
		if (score < 60) result = "F";
		else if (score < 70) result = "D";
		else if (score < 80) result = "C";
		else if (score < 90) result = "B";
		else if (score <= 100) result = "A";
		
		System.out.println(result);
	}
	
}
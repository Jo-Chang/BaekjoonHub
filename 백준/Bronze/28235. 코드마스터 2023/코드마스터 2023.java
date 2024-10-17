import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		String result = "";
		
		switch(word) {
		case "SONGDO":
			result = "HIGHSCHOOL";
			break;
		case "CODE":
			result = "MASTER";
			break;
		case "2023":
			result = "0611";
			break;
		case "ALGORITHM":
			result = "CONTEST";
			break;
		}
		
		System.out.println(result);
	}
	
}
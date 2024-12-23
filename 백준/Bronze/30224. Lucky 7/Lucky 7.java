import java.io.*;
import java.util.*;

public class Main {
		
	public static void main(String[] args) {
		
		String number = new Scanner(System.in).next();
		int n = Integer.parseInt(number), answer = 0;
		
		if (number.contains("7")) answer += 2; 
		if (n % 7 == 0) answer++;
		
		System.out.println(answer);
		
	}
	
	
}
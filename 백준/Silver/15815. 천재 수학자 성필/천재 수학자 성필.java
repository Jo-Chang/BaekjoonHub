import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			
			int a = 0, b = 0;
			switch(ch) {
			case '+':
				a = stack.pop();
				b = stack.pop();
				stack.add(b + a);
				break;
			case '-':
				a = stack.pop();
				b = stack.pop();
				stack.add(b - a);
				break;
			case '*':
				a = stack.pop();
				b = stack.pop();
				stack.add(b * a);
				break;
			case '/':
				a = stack.pop();
				b = stack.pop();
				stack.add(b / a);
				break;
			default:
				stack.add(ch - '0');
			}
			
		}
		
		System.out.println(stack.pop());
		
	}
	
}
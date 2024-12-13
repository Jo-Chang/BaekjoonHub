import java.io.*;
import java.util.*;

public class Main {
	
	static String[] binary = {
			"000", "001", "010", "011",
			"100", "101", "110", "111"
	};
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in = br.readLine();
		
		sb.append(Integer.parseInt(binary[in.charAt(0) - '0']));
		for (int i = 1; i < in.length(); i++) {
			sb.append(binary[in.charAt(i) - '0']);
		}
		
		System.out.println(sb);
		
	}
	
}
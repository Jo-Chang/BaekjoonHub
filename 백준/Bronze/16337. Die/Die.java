import java.io.*;
import java.util.*;

class Main {
	
	static Map<String, String> map;
	
	static {
		map = new HashMap<>();
		map.put("::::o::::", "1");
		map.put("::o:::o::", "2");
		map.put("o:::::::o", "2");
		map.put("o:::o:::o", "3");
		map.put("::o:o:o::", "3");
		map.put("o:o:::o:o", "4");
		map.put("o:o:o:o:o", "5");
		map.put("o:oo:oo:o", "6");
		map.put("ooo:::ooo", "6");
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String dice = "";
		
		for (int i = 0; i < 3; i++) {
			dice += br.readLine();
		}
		
		System.out.println(map.getOrDefault(dice, "unknown"));
		
	}
	
}
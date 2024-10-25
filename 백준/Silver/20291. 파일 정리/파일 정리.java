import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Map<String, Integer> map = new TreeMap<>();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String file = br.readLine();
			String extension = file.split("\\.")[1];
			
			map.put(extension, map.getOrDefault(extension, 0) + 1);
		}
		
		for (String key : map.keySet()) {
			sb.append(key).append(" ").append(map.get(key));
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
}
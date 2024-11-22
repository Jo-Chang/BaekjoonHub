import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] chArray = br.readLine().toCharArray();
		for (int i = 1; i < n; i++) {
			String str = br.readLine();
			int idx = 0;
			
			while (idx < chArray.length) {
				if (chArray[idx] != str.charAt(idx)) chArray[idx] = '?';
				idx++;
			}
		}
		
		System.out.println(String.valueOf(chArray));
		
	}
	
}
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String originalMBTI = br.readLine();
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		for (int i = 0; i < n ; i++) {
			String mbti = br.readLine();
			if (mbti.equals(originalMBTI)) count++;
		}
		
		System.out.println(count);
	}
	
}
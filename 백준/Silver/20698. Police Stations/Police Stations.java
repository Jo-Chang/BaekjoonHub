import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			minX = Math.min(minX, x);
			minY = Math.min(minY, y);
			
			maxX = Math.max(maxX, x);
			maxY = Math.max(maxY, y);
		}
		
		int avgX = (maxX + minX) / 2;
		int avgY = (maxY + minY) / 2;
		
		int l = Math.max(maxX - avgX, avgX - minX);
		int w = Math.max(maxY - avgY, avgY - minY);
		
		System.out.println(String.format("%d %d", l, w));
	}
}
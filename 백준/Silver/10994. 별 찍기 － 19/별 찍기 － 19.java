import java.util.*;

public class Main {
	
	static char[][] arr;
	
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		int n = new Scanner(System.in).nextInt(), len = 4 * n - 3;
		arr = new char[len][len];
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				arr[i][j] = ' ';
			}
		}
		
		setStar(len, 0);
		
		for (int i = 0; i < len; i++) {
			sb.append(String.valueOf(arr[i])).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void setStar(int n, int x) {
		if (n == 1) {
			arr[x][x] = '*';
			return;
		}
		
		for (int i = 0; i < n; i++) {
			arr[x + i][x] = arr[x][x + i] = arr[x + i][x + n - 1] = arr[x + n - 1][x + i]
					= '*';
		}
		
		setStar(n - 4, x + 2);
	}
	
}
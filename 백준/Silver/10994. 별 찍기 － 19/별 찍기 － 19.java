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
		
		setStar(n, 0, 0);
		
		for (int i = 0; i < len; i++) {
			sb.append(String.valueOf(arr[i])).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void setStar(int n, int x, int y) {
		if (n == 1) {
			arr[x][y] = '*';
			return;
		}
		
		int len = 4 * n - 3;
		
		for (int i = 0; i < len; i++) {
			arr[x + i][y] = arr[x][y + i] = arr[x + i][y + len - 1] = arr[x + len - 1][y + i]
					= '*';
		}
		
		setStar(n - 1, x + 2, y + 2);
	}
	
}
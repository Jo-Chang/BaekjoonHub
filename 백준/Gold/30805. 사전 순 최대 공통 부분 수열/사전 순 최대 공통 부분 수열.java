import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		
		int[][] arr = new int[2][];
		
		for (int i = 0; i < 2; i++) {
			int n = read();
			arr[i] = new int[n];
			for (int j = 0; j < n; j++) arr[i][j] = read();
		}
		
		List<Integer> list = findCommonSubsequence(arr[0], arr[1]);
		
		sb.append(list.size()).append("\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		System.out.println(sb);
		
	}
	
	static int read() throws IOException {
		int c, n = 0;
		while((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
		if (c == 13) System.in.read();
		return n;
	}
	
	static List<Integer> findCommonSubsequence(int[] arr1, int[] arr2) {
		List<Integer> list = new ArrayList<>(), idxs = new ArrayList<>();
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				
				point:
				if (arr1[i] == arr2[j]) {
					for (int k = 0; k < list.size(); k++) {
						if (list.get(k) < arr2[j]) {
							list.subList(k, list.size()).clear();
							idxs.subList(k, idxs.size()).clear();
							break;
						} else if (idxs.get(k) >= j) {
							break point;
						}
					}
					
					list.add(arr2[j]);
					idxs.add(j);
					break;
				}
				
			}
		}
		
		return list;
	}
	
}
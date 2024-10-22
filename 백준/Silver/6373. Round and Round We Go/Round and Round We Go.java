import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = "";
		Set<String> set = new HashSet<>();
		while ((input = br.readLine()) != null && !input.equals("")) {
			fillSetFromOrigin(set, input);
			
			sb.append(input);
			sb.append(" is ");
			if (!isCyclic(set, input)) sb.append("not ");
			sb.append("cyclic\n");
			
			set.clear();
		}
		
		System.out.println(sb);
	}
	
	static boolean isCyclic(Set<String> set, String number) {
		int n = number.length();
		char[] charNums = number.toCharArray();
		
		for (int i = 0 ; i < n - 1; i++) {
			int len = addStringNumber(charNums, number);
			if (!set.contains(String.valueOf(charNums)) || len > n) {
				return false;
			}
		}
		
		return true;
	}
	
	static void fillSetFromOrigin(Set<String> set, String origin) {
		List<Character> list = stringToList(origin);
		Collections.rotate(list, 1);
		
		set.add(origin);
		while (!listToString(list).equals(origin)) {
			set.add(listToString(list));
			Collections.rotate(list, 1);
		}
	}
	
	static String listToString(List<Character> list) {
		StringBuffer sb = new StringBuffer();

		for (char ch : list) {
			sb.append(ch);
		}
		
		return sb.toString();
	}
	
	static List<Character> stringToList(String str) {
		List<Character> list = new LinkedList<>();
		
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		return list;
	}
	
	static int addStringNumber(char[] arr, String number) {
		boolean isCarry = false;
		
		for (int i = arr.length - 1; i >= 0; i--) {
			arr[i] = (char) (arr[i] + number.charAt(i) - '0');
			
			if (isCarry) {
				arr[i]++;
				isCarry = false;
			}
			
			if (arr[i] > '9') {
				arr[i] -= 10;
				isCarry = true;
			} 
		}
		
		return arr.length + ((isCarry) ? 1 : 0);
	}
	
}
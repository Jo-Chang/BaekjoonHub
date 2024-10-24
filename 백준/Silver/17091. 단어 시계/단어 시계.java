import java.io.*;
import java.util.*;

class Main {
	
	static String[] numbers = new String[] {
			"zero", 
			"one", "two", "three", "four", "five", 
			"six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", 
			"sixteen", "seventeen", "eighteen", "nineteen", "twenty"
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int h = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		System.out.println(getWordTimeString(h, m));
	}
	
	static String getWordTimeString(int h, int m) {
		StringBuffer sb = new StringBuffer();
		
		if (m == 0) {
			sb.append(getWordHourString(h)).append(" ");
			sb.append(getWordMinuteString(m));
		} else if (m <= 30) {
			sb.append(getWordMinuteString(m)).append(" past ");
			sb.append(getWordHourString(h));
		} else {
			sb.append(getWordMinuteString(60 - m)).append(" to ");
			sb.append(getWordHourString(h + 1));
		}
		
		return sb.toString();
	}
	
	static String getWordHourString(int h) {
		if (h > 12) {
			h -= 12;
		}
		
		return numbers[h];
	}
	
	static String getWordMinuteString(int m) {
		String result = "";
		
		switch(m) {
		case 0:
			result = "o' clock";
			break;
		case 1:
			result = numbers[m] + " minute";
			break;
		case 15:
			result = "quarter";
			break;
		case 30:
			result = "half";
			break;
		default: 
			if (m <= 20) {
				result = numbers[m] + " minutes";
			} else if (m < 30) {
				result = numbers[20] + " " + numbers[m - 20] + " minutes";
			}
		}
		
		return result;
	}
	
}
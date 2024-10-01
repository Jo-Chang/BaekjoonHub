import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		SortedWords words = new SortedWords();
		
		for (int i = 0; i < n; i++) {
			words.add(br.readLine());
		}
		
		for (String word : words.getWords()) {
			sb.append(word).append("\n");
		}
		
		System.out.println(sb);
	}
	
}

class SortedWords {
	
	List<String> words;
	
	SortedWords() {
		words = new ArrayList<>();	
	}
	
	void add(String newWord) {
		for (int i = 0; i < words.size(); i++) {
			String word = words.get(i);
			
			if (newWord.equals(word)) {
				return;
			} else if (newWord.length() < word.length()) {
				words.add(i, newWord);
				return;
			} else if (newWord.length() == word.length() && newWord.compareTo(word) < 0) {
				words.add(i, newWord);
				return;
			} 
		}
		
		words.add(words.size(), newWord);
	}
	
	List<String> getWords() {
		return this.words;
	}
	
}
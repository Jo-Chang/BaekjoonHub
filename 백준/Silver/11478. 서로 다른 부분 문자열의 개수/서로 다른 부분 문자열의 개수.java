import java.io.*;
import java.util.Set;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String word = br.readLine().strip();
    Set<String> s = new HashSet<>();

    for (int i = 1; i <= word.length(); i++) {
      for (int j = 0; j <= word.length() - i; j++) {
        s.add(word.substring(j, j + i));
      }
    }

    System.out.println(s.size());
  }
}

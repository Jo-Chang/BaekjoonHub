import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  void solution() throws IOException {
    String word = br.readLine().strip();
    Set<String> s = new HashSet<>();

    for (int i = 1; i <= word.length(); i++) {
      for (int j = 0; j <= word.length() - i; j++) {
        s.add(word.substring(j, j + i));
      }
    }

    System.out.println(s.size());
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
  private void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] words = br.readLine().trim().split(" ");
    
    int cnt = 0;

    // for (int i = 0; i < words.length; i++) {
    //   for (int j = 0; j < words[i].length(); j++) {
    //     System.out.print(words[i].charAt(j) + "?");
    //   }
    //   System.out.println();
    // }
    // System.out.print(words.length);

    for (String word: words) {
      if (!word.isEmpty()) cnt++;
    }
    System.out.println(cnt);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
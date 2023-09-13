import java.io.*;


public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private void solution() throws IOException {
    int T = Integer.parseInt(br.readLine());
    
    while (T-- > 0) {
      String word = br.readLine();
      System.out.printf("%c%c\n", word.charAt(0), word.charAt(word.length() - 1));
    }
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
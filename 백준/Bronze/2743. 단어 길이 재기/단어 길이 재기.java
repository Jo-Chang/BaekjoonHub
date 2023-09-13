import java.io.*;


public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private void solution() throws IOException {
    String word = br.readLine();

    System.out.println(word.length());
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
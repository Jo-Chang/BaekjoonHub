import java.io.*;


public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  private void solution() throws IOException {
    String S = br.readLine();
    int i = Integer.parseInt(br.readLine());

    System.out.println(S.charAt(i - 1));
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
import java.io.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuilder sb = new StringBuilder();

  void solution() throws IOException {
    String input = br.readLine();

    while (!input.equals("0")) {
      String answer = "yes";
      for (int i = 0; i < input.length() / 2; i++) {
        if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
          answer = "no";
          break;
        }
      }
      sb.append(answer + "\n");

      input = br.readLine();
    }

    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
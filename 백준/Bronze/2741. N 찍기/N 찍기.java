import java.io.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuilder sb = new StringBuilder();

  void solution() throws IOException {
    int n = Integer.parseInt(br.readLine());

    for (int i = 1; i <= n; i++) {
      sb.append(i).append("\n");
    }

    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
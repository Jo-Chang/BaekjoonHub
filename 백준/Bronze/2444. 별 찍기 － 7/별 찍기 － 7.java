import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n - 1; j++) {
        sb.append(" ");
      }
      for (int j = 0; j < 2 * i + 1; j++) {
        sb.append("*");
      }
      sb.append("\n");
    }
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j <= i; j++) {
        sb.append(" ");
      }
      for (int j = 0; j < 2 * (n - i - 1) - 1; j++) {
        sb.append("*");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
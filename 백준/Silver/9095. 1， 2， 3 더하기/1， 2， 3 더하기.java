import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  int answer = 0;

  void solution() throws IOException {
    int tc = Integer.parseInt(br.readLine());

    int[] dp = new int[12];

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for (int i = 4; i <= 11; i++) {
      dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
    }
    while (tc-- > 0) {
      int n = Integer.parseInt(br.readLine());

      System.out.println(dp[n]);
    }
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
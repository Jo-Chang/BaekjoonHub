import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int answer = 0;
  int n;
  void solution() throws IOException {
    int n = Integer.parseInt(br.readLine());

    int a = n;

    while (a >= 0) {
      if ((n - a) % 2 == 0) {
        answer += combination((n - a) / 2 + a, a);
      }
      a--;
    }

    System.out.println(answer % 10007);
  }

  int combination(int n, int k) {
    double result = 1;
    for (int i = 0; i < k; i++) {
      result *= (n - i);
      result /= (i + 1);
      result %= 10007;
    }

    return (int)result;
  }

  void solution2() throws IOException {
    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[n];

    dp[0] = 1;
    if (n > 1) {
      dp[1] = 2;
      for (int i = 2; i < n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
        dp[i] %= 10007;
      }
    }

    System.out.println(dp[n - 1]);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution2();
  }
}
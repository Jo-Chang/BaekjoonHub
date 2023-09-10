import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n;
    int[] s = new int[10000];
    int[] dp = new int[10000];

    n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      s[i] = Integer.parseInt(br.readLine());
    }

    dp[0] = s[0];
    dp[1] = s[0] + s[1];
    dp[2] = Math.max(Math.max(s[0] + s[2], s[1] + s[2]), dp[1]);
    for (int i = 3; i < n; i++) {
      dp[i] = Math.max(Math.max(dp[i - 2] + s[i], dp[i - 3] + s[i - 1] + s[i]), dp[i - 1]);
    }

    bw.write(String.valueOf(dp[n - 1]));

    bw.flush();
    bw.close();
  }
}
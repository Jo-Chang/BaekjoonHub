import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Boj9465().sol();
  }
}

class Boj9465 {
  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[2][n];
      for (int i = 0; i < 2; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int[][] dp = new int[n][3];
      dp[0][0] = arr[0][0]; // 위를 고른 경우
      dp[0][1] = arr[1][0]; // 아래를 고른 경우
      dp[0][2] = 0;         // 고르지 않은 경우
      for (int i = 1; i < n; i++) {
        dp[i][0] = Math.max(dp[i - 1][2], dp[i - 1][1]) + arr[0][i];
        dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][0]) + arr[1][i];
        dp[i][2] = Math.max(dp[i - 1][2], Math.max(dp[i - 1][0], dp[i - 1][1]));
      }

      sb.append(Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2])).append("\n");
    }
    br.close();

    System.out.println(sb);
  }
}
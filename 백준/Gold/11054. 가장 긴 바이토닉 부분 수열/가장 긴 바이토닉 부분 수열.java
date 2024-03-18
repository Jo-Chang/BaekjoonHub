import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new BOJ11054().sol();
  }
}

class BOJ11054 {
  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
    br.close();

    int[][] dp = new int[N][2];
    // dp[i][0] -> Increasing
    // dp[i][1] -> Decreasing
    for (int i = 0; i < N; i++) {
      dp[i][0] = dp[i][1] = 1;
      
      // Increasing
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1);
      }

      // Decreasing
      for (int j = 0; j < i; j++) {
        if (arr[i] < arr[j]) dp[i][1] = Math.max(dp[i][1], Math.max(dp[j][0], dp[j][1]) + 1);
      }
    }
    
    int answer = 0;
    for (int i = 0; i < N; i++) answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
    System.out.println(answer);
  }
}
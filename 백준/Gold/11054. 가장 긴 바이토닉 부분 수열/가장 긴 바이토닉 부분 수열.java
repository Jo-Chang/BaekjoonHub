import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new BOJ11054().sol();
  }
}

class BOJ11054 {
  void sol() throws IOException {
    int N = readInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) arr[i] = readInt();

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

  int readInt() throws IOException {
    int input = System.in.read();
    int num = 0;

    while (input > 32) {
      num = (num << 3) + (num << 1) + (input & 15);
      input = System.in.read();
    }

    return num;
  }
}
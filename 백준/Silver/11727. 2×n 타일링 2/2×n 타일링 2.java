import java.io.*;

class Main {
  static final int LIMIT = 10007;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    br.close();

    int[] dp = new int[N + 1];
    dp[1] = 1; 
    if (N > 1) {
      dp[2] = 3;
      for (int i = 3; i <= N; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2] * 2) % LIMIT;
      }
    }
    
    System.out.println(dp[N]);
  }
}
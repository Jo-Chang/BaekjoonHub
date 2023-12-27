import java.io.*;

public class Main {
  int N;
  int[] dp;
  boolean DEBUG = false;

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }

  void solution() throws  IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    dp = new int[50001];

    System.out.println(getLagrange(N));
    
    if (DEBUG) debugPrint();
  }

  int getLagrange(int n) {
    for (int i = 1; i < 4; i++) dp[i] = i;
    for (int i = 4; i <= n; i++) {
      if (isSquare(i)) dp[i] = 1;
      else {
        int squareRoot = (int)Math.sqrt(i);
        for (int j = 1; j <= squareRoot; j++) {
          int square = (int)Math.pow(j, 2);
          int newCnt = dp[square] + dp[i - square];
          if (dp[i] == 0) dp[i] = newCnt;
          else dp[i] = Math.min(dp[i], newCnt);
        }
      }
    }

    return dp[n];
  }

  boolean isSquare(int n) {
    return (Math.sqrt(n) % 1 == 0);
  }  

  void debugPrint() {
    System.out.println("Debug!");
    for (int i = 0; i <= N; i++) {
      
      System.out.print(String.format("[%d]%d, ", i, dp[i]));
      if (isSquare(i + 1)) System.out.println();
    }
    System.out.print("\nDebug Ends!");
  }
}
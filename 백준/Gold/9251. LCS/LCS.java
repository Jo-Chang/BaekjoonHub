import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Boj9251().sol();
  }
}

class Boj9251 {
  int[][] dp;
  
  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    char[] str1 = br.readLine().toCharArray();
    char[] str2 = br.readLine().toCharArray();
    br.close();

    System.out.println(findLCS(str1, str2));
  }

  int findLCS(char[] str1, char[] str2) {
    int answer = 0;

    dp = new int[str1.length + 1][str2.length + 1];

    for (int i = 1; i <= str1.length; i++) {
      for (int j = 1; j <= str2.length; j++) {
        if (str1[i - 1] == str2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

        answer = Math.max(dp[i][j], answer);
      }
    }

    return answer;
  }
}
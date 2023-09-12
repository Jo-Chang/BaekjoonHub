import java.io.*;
import java.util.StringTokenizer;

public class Main {
  private int max(int[] arr) {
    int maxNum = 0;

    for (int mem : arr) {
      maxNum = mem > maxNum ? mem : maxNum;
    }

    return maxNum;
  }

  private void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n], dp = new int[n];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    bw.write(String.valueOf(max(dp)));

    bw.flush();

  }

  public static void main(String[] args) throws IOException{
    new Main().solution();  
  }
}

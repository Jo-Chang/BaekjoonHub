import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Boj2096().sol();
  }
}

class Boj2096 {
  int[][] arr;
  int[][] maxDP, minDP;
  int max, min;

  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    arr = new int[N][3];
    maxDP = new int[N][3];
    minDP = new int[N][3];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
      arr[i][2] = Integer.parseInt(st.nextToken());
    }
    br.close();

    for (int i = 0 ; i < 3; i++) maxDP[0][i] = minDP[0][i] = arr[0][i];
    for (int i = 1; i < N; i++) {
      maxDP[i][0] = arr[i][0] + Math.max(maxDP[i-1][0], maxDP[i-1][1]);
      maxDP[i][1] = arr[i][1] + Math.max(maxDP[i-1][0], Math.max(maxDP[i-1][1], maxDP[i-1][2]));
      maxDP[i][2] = arr[i][2] + Math.max(maxDP[i-1][1], maxDP[i-1][2]);

      minDP[i][0] = arr[i][0] + Math.min(minDP[i-1][0], minDP[i-1][1]);
      minDP[i][1] = arr[i][1] + Math.min(minDP[i-1][0], Math.min(minDP[i-1][1], minDP[i-1][2]));
      minDP[i][2] = arr[i][2] + Math.min(minDP[i-1][1], minDP[i-1][2]);
    }

    max = Arrays.stream(maxDP[N-1]).max().getAsInt();
    min = Arrays.stream(minDP[N-1]).min().getAsInt();

    System.out.println(max + " " + min);
  }
}
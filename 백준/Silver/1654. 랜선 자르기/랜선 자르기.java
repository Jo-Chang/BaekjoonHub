import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  void solution() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());

    int k = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    int[] lans = new int[k];
    long sum = 0;
    for (int i = 0; i < k; i++) {
      lans[i] = Integer.parseInt(br.readLine());
      sum += lans[i];
    }

    // int l = 1, r = (int)(sum / n), mid;
    // int answer, cnt = 0;
    long l = 1, r = sum / n, mid;
    long answer;
    int cnt = 0;
    while (l <= r) {
      cnt = 0;
      mid = (l + r) / 2;

      for (int lan : lans) {
        cnt += lan / mid;
      }

      if (cnt < n) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    answer = r;

    System.out.println(answer);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
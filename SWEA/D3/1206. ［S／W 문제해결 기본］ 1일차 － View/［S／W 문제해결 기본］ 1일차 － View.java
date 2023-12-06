import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
  static final int TEST_CASE = 10;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    for (int tc = 1; tc <= TEST_CASE; tc++) {
      int answer = 0;
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      // [0]
      if (arr[0] > arr[1] && arr[0] > arr[2]) answer += arr[0] - Math.max(arr[1], arr[2]);
      // [1]
      if (arr[1] > arr[0] && arr[1] > arr[2] && arr[1] > arr[3]) answer += arr[1] - Math.max(arr[0], Math.max(arr[2], arr[3]));
      for (int i = 2; i < n - 2; i++) {
        if (arr[i] > arr[i - 2] && arr[i] > arr[i - 1] && arr[i] > arr[i + 1] && arr[i] > arr[i + 2]) {
          answer += arr[i] - Math.max(Math.max(arr[i - 2], arr[i - 1]), Math.max(arr[i + 1], arr[i + 2]));
        }
      }
      // [n - 2]
      if (arr[n - 2] > arr[n - 4] && arr[n - 2] > arr[n - 3] && arr[n - 2] > arr[n - 1]) answer += arr[n - 2] - Math.max(arr[n - 4], Math.max(arr[n - 3], arr[n - 1]));
      // [n - 1]
      if (arr[n - 1] > arr[n - 3] && arr[n - 1] > arr[n - 2]) answer += arr[n - 1] - Math.max(arr[n - 3], arr[n - 2]);

      sb.append("#" + tc + " " + answer + "\n");
    }
    br.close();
    System.out.println(sb);
  }
}
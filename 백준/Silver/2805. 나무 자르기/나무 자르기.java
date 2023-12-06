import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
    int[] woods = new int[n];
    int max = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      woods[i] = Integer.parseInt(st.nextToken());
      max = Math.max(max, woods[i]);
    }
    br.close();

    int start = 0, end = max, mid = 0;
    while (start <= end) {
      long cnt = 0;
      for (int i = 0; i < n; i++) {
        if (woods[i] > mid) cnt += woods[i] - mid;
      }
      
      if (cnt > m) {
        start = mid + 1;
      } else if (cnt < m) {
        end = mid - 1;
      } else {
        break;
      }

      mid = (start + end) / 2;
    }

    System.out.println(mid);
  }
}
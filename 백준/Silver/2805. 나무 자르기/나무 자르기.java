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
    int answer = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      woods[i] = Integer.parseInt(st.nextToken());
    }
    br.close();

    Arrays.sort(woods);

    int startIdx = 0, endIdx = n, midIdx = (startIdx + endIdx) / 2;
    long cnt = 0;
    while (startIdx < endIdx) {
      cnt = 0;
      for (int i = midIdx; i < n; i++) {
        if (woods[i] > woods[midIdx]) cnt += woods[i] - woods[midIdx];
      }

      if (cnt > m) {
        startIdx = midIdx + 1;
      } else if (cnt < m) {
        endIdx = midIdx;
      } else {
        break;
      }

      midIdx = (startIdx + endIdx) / 2;
    }

    int start = 0;
    if (midIdx > 0) start = woods[midIdx - 1];
    int end = woods[midIdx];
    if (midIdx < n - 1) end = woods[midIdx + 1];
    int mid = 0;
    while (start < end) {
      mid = (start + end) / 2;
      
      cnt = 0;
      for (int i = midIdx; i < n; i++) {
        if (woods[i] > mid) cnt += woods[i] - mid;
      }
      
      if (cnt > m) {
        start = mid + 1;
      } else if (cnt < m) {
        end = mid;
      } else {
        break;
      }
    }
    answer = mid;

    while (cnt < m) {
      answer--;
      cnt = 0;
      for (int i = midIdx; i < n; i++) {
        if (woods[i] > mid) cnt += woods[i] - answer;
      }
    }

    System.out.println(answer);
  }
}
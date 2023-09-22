import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuilder sb = new StringBuilder();

  void solution() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] nums = new int[3];
    for (int i = 0; i < 3; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    while (nums[0] + nums[1] + nums[2] > 0) {
      int maxIdx = 0;
      for (int i = 1; i < 3; i++) {
        if (nums[i] > nums[maxIdx]) maxIdx = i;
      }
      int sum1 = 0, sum2 = 0;
      for (int i = 0; i < 3; i++) {
        if (i == maxIdx) {
          sum1 = nums[maxIdx] * nums[maxIdx];
        } else {
          sum2 += nums[i] * nums[i];
        }
      }

      if (sum1 == sum2) sb.append("right\n");
      else sb.append("wrong\n");

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 3; i++) {
        nums[i] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
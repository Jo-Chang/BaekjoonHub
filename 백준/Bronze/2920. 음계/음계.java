import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  final int CASE = 8;

  void solution() throws IOException {
    int[] nums = new int[CASE], ascending = new int[CASE], descending = new int[CASE];
    String answer = "mixed";

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < CASE; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
      ascending[i] = i + 1;
      descending[i] = CASE - i;
    }

    if (nums[0] == 1) {
      if (Arrays.equals(nums, ascending)) {
        answer = "ascending";
      }
    } else if (nums[0] == CASE) {
      if (Arrays.equals(nums, descending)) {
        answer = "descending";
      }
    }

    System.out.println(answer);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
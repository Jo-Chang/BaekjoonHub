import java.util.*;

public class Solution {
  static final int RED = 0, BLUE = 1, GREEN = 2, BOX_COUNT = 3;
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int testcase = sc.nextInt();
    for (int tc = 1; tc <= testcase; tc++) {
      long answer = 0;
      int n = sc.nextInt();
      int[][] arr = new int[n][3];
      int[] maxArr = new int[n];
      
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < BOX_COUNT; j++) arr[i][j] = sc.nextInt();
        maxArr[i] = Math.max(arr[i][0], Math.max(arr[i][1], arr[i][2]));
        answer += arr[i][RED] + arr[i][BLUE] + arr[i][GREEN] - maxArr[i];
      }

      // 박스의 갯수(n)이 3 미만이라면 -1
      if (n < 3) {
        answer = -1;
      } else {
        int resizingNum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
              if (i == j || j == k || k == i) continue;
              
              resizingNum = Math.min(resizingNum, maxArr[i] + maxArr[j] + maxArr[k] - arr[i][RED] - arr[j][BLUE] - arr[k][GREEN]);
            }
          }
        }
        answer += resizingNum;
      }
      sb.append(String.format("#%d %d\n", tc, answer));
    }
    sc.close();
    System.out.println(sb);
  }
}
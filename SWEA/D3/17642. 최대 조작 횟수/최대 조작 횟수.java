import java.io.*;
import java.util.StringTokenizer;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    for (int tc = 1; tc <= T; tc++) {
      long answer = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      long A = Long.parseLong(st.nextToken());
      long B = Long.parseLong(st.nextToken());
      long diff = B - A;
      if (diff == 0) {
        answer = 0;
      } else if (diff < 2) {
        answer = -1;
      } else {
        answer = diff / 2;
      }
      
      sb.append(String.format("#%d %d\n", tc, answer));
    }
    br.close();
    System.out.println(sb);
  }
}
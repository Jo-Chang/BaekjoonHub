import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int testcase = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= testcase; tc++) {
      String answer = "";
      StringTokenizer st = new StringTokenizer(br.readLine());
      String a = st.nextToken();
      String b = st.nextToken();

      if (a.equals(b)) answer = a;
      else answer = "1";
      sb.append(String.format("#%d %s\n", tc, answer));
    }
    
    br.close();
    System.out.println(sb);
  }
}
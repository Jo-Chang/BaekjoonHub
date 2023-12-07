import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    int testcase = Integer.parseInt(br.readLine());
    for (int tc = 1; tc <= testcase; tc++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      
      double answer = Math.min(Math.abs((double)(a + c) / 2 - b), Math.abs(2 * b - c - a));
      sb.append(String.format("#%d %.1f\n", tc, answer));
    }
    bw.write(sb.toString());
    br.close();
    bw.close();
  }
}
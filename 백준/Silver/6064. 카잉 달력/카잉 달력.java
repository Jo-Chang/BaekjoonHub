import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int testcase = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < testcase; tc++) {
      int answer = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      final int LCM = getLCM(m, n);

      int kx = x, ky = y;
      while (kx <= LCM && ky <= LCM) {
        if (kx < ky) {
          kx += m;
        } else if (kx > ky) {
          ky += n;
        } else {
          answer = kx;
          break;
        }
      }
      if (kx > LCM || ky > LCM) answer = -1;

      sb.append(answer + "\n");
    }
    br.close();
    System.out.println(sb);
  }

  static int getLCM(int m, int n) {
    int result = 0;
    int gcd = 1;
    int km = m, kn = n;
    while (true) {
      if (km > kn) {
        if (km % kn == 0) {
          gcd = kn;
          break;
        } else km %= kn;
      } else {
        if (kn % km == 0) {
          gcd = km;
          break;
        } else kn %= km;
      }
    }
    result = m * n / gcd;
    return result;
  }
}
import java.io.*;
import java.util.*;

class Main {
  static StringBuilder sb;
  static int N;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    // Input
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    br.close();

    sol1();
    // sol2();

    System.out.println(sb);
  }

  // O(N^2) 예상, 알고리즘 간편
  static void sol1() {
    int idx = 0;
    for (int i = 1; i < N; i++) {
      sb.append(idx + 1).append(" ");

      int move = arr[idx];
      arr[idx] = 0;

      if (move > 0) {
        int j = 0;
        while (j < move) {
          idx = (idx + 1) % N;

          if (arr[idx] == 0)
            continue;

          j++;
        }
      } else {
        int j = 0;
        while (j > move) {
          idx = (idx + N - 1) % N;

          if (arr[idx] == 0)
            continue;

          j--;
        }
      }
    }

    for (int i = 0; i < N; i++) {
      if (arr[i] != 0) {
        sb.append(i + 1);
        break;
      }
    }
  }

  static void sol2() {

  }
}
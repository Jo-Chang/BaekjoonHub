import java.io.*;
import java.util.*;

class Main {
  int N;
  LinkedList<int[]> comb;

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }

  void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    comb = new LinkedList<>();
    
    int T = Integer.parseInt(br.readLine());
    for (int tc = 0; tc < T; tc++) {
      // input
      N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      char[][] mbtis = new char[N][4];
      for (int i = 0; i < N; i++) {
        mbtis[i] = st.nextToken().toCharArray();
      }
      
      int answer = 0;
      if (N <= 32) {
        combination(new int[3], 0, 0);

        answer = Integer.MAX_VALUE;
        for (int[] ele : comb) {
          answer = Math.min(answer, getDiffNum(mbtis, ele));
        }
      }

      sb.append(answer).append("\n");
      comb.clear();
    }
    br.close();
    System.out.println(sb);
  }

  // n C 3 의 모든 경우의 수
  void combination(int[] arr, int depth, int pointer) {
    if (depth == 3) {
      comb.add(arr);
    } else {
      for (int i = pointer; i < N - 2 + depth; i++) {
        arr[depth] = i;
        combination(arr.clone(), depth + 1, i + 1);
      }
    }
  }

  int getDiffNum(char[][] mbtis, int[] ele) {
    int diff = 0;

    for (int i = 0; i < 4; i++) {
      diff += mbtis[ele[0]][i] == mbtis[ele[1]][i] ? 0 : 1;
      diff += mbtis[ele[0]][i] == mbtis[ele[2]][i] ? 0 : 1;
      diff += mbtis[ele[1]][i] == mbtis[ele[2]][i] ? 0 : 1;
    }

    return diff;
  }
}
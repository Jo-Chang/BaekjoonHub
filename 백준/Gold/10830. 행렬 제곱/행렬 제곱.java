import java.io.*;
import java.util.*;


public class Main {
  public static void main(String[] args) throws IOException {
    new Boj10830().sol();    
  }
}

class Boj10830 {
  StringBuilder sb;

  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    int[][] arr = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        arr[i][j] %= 1000;
      }
    }
    br.close();

    arr = mergeConquer(arr, B, B);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) sb.append(arr[i][j]).append(" ");
      sb.append("\n");
    }

    System.out.println(sb);
  }

  int[][] copy2D(int[][] arr) {
    int l = arr.length;
    int[][] copy = new int[l][l];

    for (int i = 0; i < l; i++) {
      for (int j = 0; j < l; j++) copy[i][j] = arr[i][j];
    }

    return copy;
  }

  int[][] mergeConquer(int[][] arr, long B, long depth) {
    if (depth == 1) return arr;

    int l = arr.length;
    int[][] result = new int[l][l];

    int[][] arrHalf = mergeConquer(arr, B, depth / 2);

    for (int i = 0; i < l; i++) {
      for (int j = 0; j < l; j++) {
        for (int k = 0; k < l; k++) {
          result[i][j] += arrHalf[i][k] * arrHalf[k][j];
          result[i][j] %= 1000;
        }
      }
    }
    
    if (depth % 2 == 1) {
      int[][] oddResult = new int[l][l];
      for (int i = 0; i < l; i++) {
        for (int j = 0; j < l; j++) {
          for (int k = 0; k < l; k++) {
            oddResult[i][j] += result[i][k] * arr[k][j];
            oddResult[i][j] %= 1000;
          }
        }
      }

      return oddResult;
    }

    return result;
  }
}
import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {
  public static void main(String[] args) throws IOException {
    new Boj10813().solution();
  }
}

class Boj10813 {
  int N, M;
  int[] arr;

  void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = IntStream.rangeClosed(1, N).toArray();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      swap(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
    }
    br.close();
    Arrays.stream(arr).forEach(s -> System.out.print(String.format(s + " ")));
  }

  void swap(int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Boj11055().sol();
  }
}

class Boj11055 {
  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    int[] bis = new int[N];
    for (int i = 0; i < N; i++) {
      bis[i] = arr[i];
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) bis[i] = Math.max(bis[i], bis[j] + arr[i]);
      }
    }

    // System.out.println(Arrays.stream(bis).max().getAsInt());
    int max = 0;
    for (int m : bis) max = Math.max(max, m);
    System.out.println(max);
  }
}
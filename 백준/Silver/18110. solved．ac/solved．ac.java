import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  final double RATIO = 0.15;

  int readInt() throws IOException {
    int n = 0;

    while (true) {
      int input = System.in.read();
      if (input <= 32) {
        //  입력이 공백인 경우
        return n;
      } else {
        n = (n << 3) + (n << 1) + (input & 15);
      }
    }
  }

  void solution() throws IOException {
    int answer;
    int n = readInt();
    
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = readInt();
    }
    
    Arrays.sort(nums);
    
    int ex = (int)Math.round((double)n * RATIO);
    int sum = 0;
    for (int i = ex; i < n - ex; i++) {
      sum += nums[i];
    }

    answer = (int)Math.round((double)sum / (n - ex * 2));
    System.out.println(answer);
  }

  void solution2() throws IOException {
    int n = readInt();
    int ex = (int)Math.round(n * RATIO);
    int len = n - 2 * ex;
    PriorityQueue<Integer> q = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      q.add(readInt());
    }

    for (int i = 0; i < ex; i++) {
      q.poll();
    }

    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += q.poll();
    }

    System.out.println(Math.round((double)sum / len));
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
    // new Main().solution2();
  }
}
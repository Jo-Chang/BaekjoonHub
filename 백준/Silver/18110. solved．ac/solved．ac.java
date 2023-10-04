import java.io.*;
import java.util.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  final double RATIO = 0.15;

  int readInt() throws IOException {
    return Integer.parseInt(br.readLine());
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

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
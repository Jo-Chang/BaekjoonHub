import java.io.*;
import java.util.StringTokenizer;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  void solution() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int[] nums = {0, 0, 0, 0, 0};
    int sum = 0;

    for (int i = 0; i < 5; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    for (int num : nums) {
      sum += Math.pow(num, 2);
    }
    
    System.out.println(sum % 10);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
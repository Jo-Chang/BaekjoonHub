import java.io.*;
import java.util.StringTokenizer;

public class Main {
  private void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n], dp = new int[n];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    bw.write(String.valueOf(max(dp)));

    bw.flush();
    bw.close();
  }

  private int max(int[] arr) {
    int maxNum = 0;

    for (int mem : arr) {
      maxNum = mem > maxNum ? mem : maxNum;
    }

    return maxNum;
  }

  private void solution2() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n], lis = new int[n];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int idx = 0;
    lis[idx] = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] > lis[idx]) {
        lis[++idx] = arr[i];
      } else {
        lis[getBinarySearchIndex(lis, 0, idx, arr[i])] = arr[i];
      }
    }

    System.out.println(idx + 1);
  }

  private int getBinarySearchIndex(int[] lis, int start, int end, int find) {
    int mid;

    while (start < end) {
      mid = (start + end) / 2;

      if (find > lis[mid]) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    return end;
  }

  public static void main(String[] args) throws IOException{
    // new Boj11053().solution();  
    new Main().solution2();  
  }
}

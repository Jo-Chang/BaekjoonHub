import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
  private void reverse(int[] arr, int i, int j) {
    int m = (i + j) / 2, tmp;

    while (i <= m) {
      tmp = arr[i - 1];
      arr[i - 1] = arr[j - 1];
      arr[j - 1] = tmp;
      i++;
      j--;
    }
  }

  private void solution() throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
    int i, j;
    int[] arr = IntStream.range(1, n + 1).toArray();

    while (m-- > 0) {
      st = new StringTokenizer(br.readLine());
      i = Integer.parseInt(st.nextToken());
      j = Integer.parseInt(st.nextToken());

      reverse(arr, i, j);
    }

    for (int k = 0; k < n; k++) {
      sb.append(arr[k]).append(" ");
    }

    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

    int[][] arr = new int[N][N];
    int[][] acc = new int[N + 1][N + 1];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        acc[i+1][j+1] = acc[i][j + 1] + acc[i + 1][j] - acc[i][j] + arr[i][j];
      }
    }

    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());

      int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()), x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken());
      int answer = acc[x2][y2] - acc[x1 - 1][y2] - acc[x2][y1 - 1] + acc[x1 - 1][y1 - 1];

      bw.write(String.valueOf(answer) + "\n");
    }

    bw.flush();
    bw.close();
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}

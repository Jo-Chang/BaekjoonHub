import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  private double getDistance(int x, int y, int cx, int cy) {
    return Math.sqrt(Math.pow(x - cx, 2) + Math.pow(y - cy, 2));
  }

  private void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int tc = Integer.parseInt(br.readLine());
    int x1, y1, x2, y2, n, cx, cy, r;
    int answer;
    double dist1, dist2;

    while (tc-- > 0) {
      answer = 0;
      st = new StringTokenizer(br.readLine());
      x1 = Integer.parseInt(st.nextToken());
      y1 = Integer.parseInt(st.nextToken());
      x2 = Integer.parseInt(st.nextToken());
      y2 = Integer.parseInt(st.nextToken());
      
      n = Integer.parseInt(br.readLine());
      while (n-- > 0) {
        st = new StringTokenizer(br.readLine());
        cx = Integer.parseInt(st.nextToken());
        cy = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        dist1 = getDistance(x1, y1, cx, cy);
        dist2 = getDistance(x2, y2, cx, cy);

        if ((dist1 < r) != (dist2 < r)) {answer++;
        }
      }

      bw.write(String.valueOf(answer));
      bw.newLine();
    }

    bw.flush();
    bw.close();
  }
  
  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
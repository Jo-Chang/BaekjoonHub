import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Boj25191().sol();
  }
}

class Boj25191 {
  void sol() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    br.close();

    int answer = 0;

    answer = Math.min(N, A / 2 + B);

    System.out.println(answer);
  }
}
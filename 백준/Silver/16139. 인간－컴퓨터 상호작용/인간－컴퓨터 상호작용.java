import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String word = br.readLine();
    int q = Integer.parseInt(br.readLine());
    char a;
    int l, r;

    while (q-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      a = st.nextToken().charAt(0);
      l = Integer.parseInt(st.nextToken());
      r = Integer.parseInt(st.nextToken());

      int cnt = 0;
      for (int i = l; i <= r; i++) {
        if (word.charAt(i) == a) cnt++;
      }

      System.out.println(cnt);
    }
  }  
}

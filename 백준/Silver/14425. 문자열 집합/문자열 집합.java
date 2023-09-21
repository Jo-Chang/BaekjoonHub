import java.io.*;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  void solution() throws IOException {
    Set<String> set = new HashSet<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
    int answer = 0;

    while (n-- > 0) {
      set.add(br.readLine().strip());
    }

    while (m-- > 0) {
      String inStr = br.readLine().strip();

      if (set.contains(inStr)) answer++;
    }

    System.out.println(answer);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();  
  }  
}

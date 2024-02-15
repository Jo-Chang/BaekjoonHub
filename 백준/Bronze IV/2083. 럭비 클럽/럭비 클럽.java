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
    StringBuilder sb = new StringBuilder();

    do {
      st = new StringTokenizer(br.readLine());

      String name = st.nextToken();
      int age = Integer.parseInt(st.nextToken());
      int weight = Integer.parseInt(st.nextToken());
      if (name.equals("#") && age == 0 && weight == 0) break;

      sb.append(name);
      if (age > 17 || weight >= 80) sb.append(" Senior\n");
      else sb.append(" Junior\n");
      
    } while (true);

    System.out.println(sb);
  }
}
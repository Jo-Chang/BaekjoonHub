import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringBuilder sb = new StringBuilder();

  void solution1() throws IOException {
    // TimeOut~~~
    int n = Integer.parseInt(br.readLine());
    ArrayList<Integer> cards = new ArrayList<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      cards.add(Integer.parseInt(st.nextToken()));
    }

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    while (m-- > 0) {
      sb.append(cards.contains(Integer.parseInt(st.nextToken()))? 1 : 0).append(" ");
    }

    System.out.println(sb);
  }

  void solution2() throws IOException {
    int n = Integer.parseInt(br.readLine());
    Set<Integer> cards = new HashSet<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      cards.add(Integer.parseInt(st.nextToken()));
    }

    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    while (m-- > 0) {
      sb.append(cards.contains(Integer.parseInt(st.nextToken()))? 1 : 0).append(" ");
    }

    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    // new Main().solution1();
    new Main().solution2();
  }
}

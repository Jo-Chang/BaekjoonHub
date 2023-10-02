import java.io.*;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  void solution() throws IOException {
    int l = Integer.parseInt(br.readLine());
    String word = br.readLine();

    final int R = 31;
    final int MODULO = 1234567891;

    long answer = 0;
    int number;

    for (int i = 0; i < l; i++) {
      number = (int)word.charAt(i) - (int)'a' + 1;
      answer += (long)Math.pow(R, i) * number % MODULO;
    }

    System.out.println(answer);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
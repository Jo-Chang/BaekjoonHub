import java.io.*;
import java.math.BigInteger;

public class Main {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  void solution() throws IOException {
    int l = Integer.parseInt(br.readLine());
    String word = br.readLine();

    final int R = 31;
    final int MODULO = 1234567891;

    // BigInteger answer = new BigInteger("0");
    // BigInteger bigNum;
    long answer = 0, hash;
    int number;

    for (int i = 0; i < l; i++) {
      number = (int)word.charAt(i) - (int)'a' + 1;
      // bigNum = new BigInteger(String.format("%d", number));
      hash = number;
      for (int j = 0; j < i; j++) {
        // bigNum = bigNum.multiply(BigInteger.valueOf(R)).remainder(BigInteger.valueOf(MODULO));
        hash = hash * R % MODULO;
      }
      // answer = answer.add(bigNum);
      answer = (answer + hash) % MODULO;
    }

    System.out.println(answer);
  }

  public static void main(String[] args) throws IOException {
    new Main().solution();
  }
}
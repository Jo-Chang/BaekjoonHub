import java.io.*;
import java.util.StringTokenizer;

public class Main {
  final static int TESTCASE = 20;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double avg = 0, sum = 0;

    for (int i = 0; i < TESTCASE; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      double volume = Double.parseDouble(st.nextToken());
      String score = st.nextToken();

      if (!score.equals("P")) {
        sum += volume;
        if (score.equals("A+")) {
          avg += volume * 4.5;
        } else if (score.equals("A0")) {
          avg += volume * 4.0;
        } else if (score.equals("B+")) {
          avg += volume * 3.5;
        } else if (score.equals("B0")) {
          avg += volume * 3.0;
        } else if (score.equals("C+")) {
          avg += volume * 2.5;
        } else if (score.equals("C0")) {
          avg += volume * 2.0;
        } else if (score.equals("D+")) {
          avg += volume * 1.5;
        } else if (score.equals("D0")) {
          avg += volume * 1.0;
        }
      }
    }

    System.out.printf("%.6f", avg / sum);
  }
}
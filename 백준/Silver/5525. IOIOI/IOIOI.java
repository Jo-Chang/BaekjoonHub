import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    String inputString = br.readLine();
    int answer = 0;
    for (int i = 0; i < inputString.length() - 2*n; i++) {
      int cnt = 0;
      for (int j = 0; j < n; j++) {
        if (inputString.charAt(i + 2*j) == 'I') cnt++;
        if (inputString.charAt(i + 2*j + 1) == 'O') cnt++;
      }
      if (inputString.charAt(i + 2*n) == 'I') cnt++;
      if (cnt == (2 * n + 1)) answer++;
    }

    br.close();
    bw.write(answer + "\n");
    bw.close();
  }
}
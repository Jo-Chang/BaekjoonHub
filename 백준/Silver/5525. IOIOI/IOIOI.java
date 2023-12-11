import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    String inputString = br.readLine();
    int answer = 0;
    boolean flag = true;
    int cnt = 0;
    for (int i = 0; i < inputString.length(); i++) {
      if (flag && inputString.charAt(i) == 'I') {
        flag = false;
        cnt++;
      } else if (!flag && inputString.charAt(i) == 'O') {
        flag = true;
        cnt++;
      } else {
        cnt = (cnt - 1) / 2 - n + 1;
        if (cnt > 0) answer += cnt;
        if (inputString.charAt(i) == 'I') {
          cnt = 1;
          flag = false;
        } else if (inputString.charAt(i) == 'O') {
          cnt = 0;
          flag = true;
        }
      }
    }
    cnt = (cnt - 1) / 2 - n + 1;
    if (cnt > 0) answer += cnt;

    br.close();
    bw.write(answer + "\n");
    bw.close();
  }
}
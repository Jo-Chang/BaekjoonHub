import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
  static class FastIO {
    BufferedReader br;
    StringTokenizer st;
    BufferedWriter bw;
    
    public FastIO() {
      br = new BufferedReader(new InputStreamReader(System.in));
      bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        }
        catch (IOException e) {
          e.printStackTrace();
        }

      }

      return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble((next())); }

    String nextLine() {
      String str = "";

      try {
        if (st.hasMoreTokens()) {
          str = st.nextToken("\n");
        }
        else {
          str = br.readLine();
        }
      }
      catch (IOException e) {
        e.printStackTrace();
      }

      return str;
    }

    void write(String str) {
      try {
        bw.write(str);
      } catch (IOException e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }

    void write(int num) {
      try {
        bw.write(String.valueOf(num));
      } catch (IOException e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
    
    void br() {
      try {
        bw.write(System.lineSeparator());
      } catch (IOException e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }

    void end() {
      try {
        bw.flush();
        bw.close();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private static double getDistance(int x1, int y1, int x2, int y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }

  private void solution() {
    FastIO fio = new FastIO();

    int tc = fio.nextInt(), answer;
		int [] nums = new int[6];
    int x1, y1, r1, x2, y2, r2;
		double dist;
		
		while(tc-- > 0) {
      for (int i = 0; i < 6; i++) {
        nums[i] = fio.nextInt();
      }
      x1 = nums[0];
      y1 = nums[1];
      r1 = nums[2];
      x2 = nums[3];
      y2 = nums[4];
      r2 = nums[5];
      
      dist = getDistance(x1, y1, x2, y2);
      
      if (dist == 0) {
          if (nums[2] == nums[5]) answer = -1;
          else answer = 0;
      }
      else if (dist <= Math.max(nums[2], nums[5])) {
          if (dist + Math.min(nums[2], nums[5]) < Math.max(nums[2], nums[5])) answer = 0;
          else if (dist + Math.min(nums[2], nums[5]) == Math.max(nums[2], nums[5])) answer = 1;
          else answer = 2;
      }
      else {
          if (dist < nums[2] + nums[5]) answer = 2;
          else if (dist == nums[2] + nums[5]) answer = 1;
          else answer = 0;
      }

      fio.write(answer);
      fio.br();
		}

    fio.end();
  }
  public static void main(String[] args) {
    new Main().solution();
  }  
}
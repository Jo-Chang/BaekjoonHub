import java.io.*;
import java.util.StringTokenizer;


public class Main
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    private boolean isEmpty(int idx) {
        return idx == 0 ? true : false;
    }
    
    private void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[1000000];
        int idx = 0;
        
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            int output = -2;
            
            switch(cmd) {
                case '1':
                    int x = Integer.parseInt(st.nextToken());
                    stack[idx++] = x;
                    break;
                case '2':   // pop()
                    if (isEmpty(idx)) {
                        output = -1;
                    } else {
                        output = stack[--idx];
                    }
                    break;
                case '3':
                    output = idx;
                    break;
                case '4':
                    if (isEmpty(idx)) {
                        output = 1;
                    } else {
                        output = 0;
                    }
                    break;
                case '5':
                    if (isEmpty(idx)) {
                        output = -1;
                    } else {
                        output = stack[idx - 1];
                    }
                    break;
                default:
                    break;
            }
            
            if(output != -2) {
                bw.write(String.valueOf(output) + "\n");
            }
        }
        
        bw.close();
    }
    
	public static void main(String[] args) throws IOException {
	    new Main().solution();	
	}
}

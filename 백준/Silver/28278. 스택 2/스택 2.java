import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;


public class Main
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    void solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        while (n-- > 0) {
            // StringTokenizer st = new StringTokenizer(br.readLine());
            String q = br.readLine();
            char cmd = q.charAt(0);
            int output = -2;
            
            switch(cmd) {
                
                case '1':
                    stack.push(Integer.parseInt(q.substring(2)));
                    break;
                    
                case '2':   // pop()
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');
                    break;
                    
                case '3':
                    sb.append(stack.size()).append('\n');
                    break;
                    
                case '4':
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                    
                case '5':
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;
                    
                default:
                    break;
            }
        }
        
        System.out.print(sb);
    }
    
	public static void main(String[] args) throws IOException {
	    new Main().solution();	
	}
}

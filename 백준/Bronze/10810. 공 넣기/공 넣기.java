import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N + 1];
        
        for (int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            
            for (int j = s; j <= e; j++) arr[j] = num;    
        }
        
        for (int i = 1; i <=N; i++) sb.append(String.format("%d ", arr[i]));
        
        br.close();
        System.out.println(sb);
    }
}
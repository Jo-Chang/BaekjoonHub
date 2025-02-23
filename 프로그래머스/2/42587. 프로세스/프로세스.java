import java.util.*;

class Process {
    int index, priority;
    
    Process(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

}

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new ArrayDeque<>();
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        
        Arrays.stream(priorities).forEach(x -> pq.add(x));
        
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Process(i, priorities[i]));
        }
        
        while (!pq.isEmpty()) {
            int curPriority = pq.remove();
            
            Process p = q.remove();
            while (!q.isEmpty() && p.priority < curPriority) {
                q.add(p);
                p = q.remove();
            }
            
            
            
            answer++;
            System.out.println(p.index + ", " + p.priority + ", answer = " + answer);
            if (p.index == location) break;
        }
        
        return answer;
    }
}
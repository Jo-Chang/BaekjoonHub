import java.util.*;

class Solution {
    
    class Pair implements Comparable<Pair> {
        int idx, order;
        
        Pair(int idx, int order) {
            this.idx = idx;
            this.order = order;
        }
        
        @Override
        public int compareTo(Pair p) {
            return this.order - p.order;
        }
    }
    
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0, num = 10000;
        Queue<Pair> pq = new PriorityQueue<>();
        
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) pq.add(new Pair(i, rank[i]));
        }
        
        for (int i = 0; i < 3; i++) {
            answer += num * pq.poll().idx;
            num /= 100;
        }
        
        return answer;
    }
}
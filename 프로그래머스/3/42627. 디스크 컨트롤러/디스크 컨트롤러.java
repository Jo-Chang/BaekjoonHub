import java.util.*;

class Solution {
    class Job implements Comparable<Job> {
        int index, requestTime, time;

        Job(int index, int requestTime, int time) {
            this.index = index;
            this.requestTime = requestTime;
            this.time = time;
        }

        @Override
        public int compareTo(Job j) {
            if (this.time == j.time) {
                if (this.requestTime == j.requestTime) return this.index - j.index;
                return this.requestTime - j.requestTime;
            }
            return this.time - j.time;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0, curTime = 0, cnt = 0, jobCnt = jobs.length;
        Queue<Job> pq = new PriorityQueue<>();
        
        while (cnt < jobCnt) {
            for (int i = 0; i < jobCnt; i++) {
                if (jobs[i][0] <= curTime) {
                    pq.add(new Job(i, jobs[i][0], jobs[i][1]));
                    jobs[i][0] = 500_001;
                }
            }
            
            if (!pq.isEmpty()) {
                Job curJob = pq.remove();
                curTime += curJob.time;
                answer += curTime - curJob.requestTime;
                cnt++;
            } else {
                curTime++;
            }
        }
        
        return answer / jobCnt;
    }
}
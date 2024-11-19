import java.io.*;
import java.util.*;

class Main {
	
	static class Job {
		int d, t;
		
		Job(int d, int t) {
			this.d = d;
			this.t = t;
		}
		
	}
	
	static Comparator<Job> jobComp = new Comparator<Job>() {
		@Override
		public int compare(Job j1, Job j2) {
			 return j1.d - j2.d;
		}
	};
	
	public static void main(String[] args) throws IOException {
		
		 int n = read(), answer = 0, day = 1;
		 Queue<Job> q = new PriorityQueue<>(jobComp);
		 Queue<Job> q2 = new PriorityQueue<>(jobComp);
		 
		 for (int i = 0; i < n; i++) {
			 int d = read(), t = read();
			 q.add(new Job(d, t));
		 }
		 
		 while (!q.isEmpty()) {
			 Job c = q.poll();
			 
			 if (c.d < day) {
				 q2.add(c);
				 continue;
			 }
			 
			 if (day % 7 > 0 && day % 7 < 6) {
				 c.t--;
				 if (c.t > 0) q.add(c);
			 } else q.add(c);
			 
			 day++;
		 }
		 
		 while (!q2.isEmpty()) {
			 Job c = q2.poll();
			 
			 if (answer + c.t > c.d) {
				 answer = -1;
				 break;
			 } 
			 
			 answer += c.t;
		 }
		 
		 System.out.println(answer);
	}
	
	static int read() throws IOException {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32) n = (n<<3) + (n<<1) + (c&15);
		if (c == 13) System.in.read();
		return n;
	}
	
}
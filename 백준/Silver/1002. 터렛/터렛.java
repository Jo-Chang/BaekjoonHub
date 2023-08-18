/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;

public class Main
{
    public static double getDistance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt(), answer;
		int [] nums = new int[6];
		double dist;
		
		for (int tc = 0; tc < testCase; tc++) {
        	for (int i = 0; i < 6; i++) {
    	        nums[i] = sc.nextInt();
	    	}
	    	
	    	dist = getDistance(nums[0], nums[3], nums[1], nums[4]);
	    	
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
	    	
	    	System.out.println(answer);
		}
	}
}

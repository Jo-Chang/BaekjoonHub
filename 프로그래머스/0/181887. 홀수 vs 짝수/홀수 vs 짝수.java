class Solution {
    public int solution(int[] num_list) {
        int oddSum = 0, evenSum = 0, i = 1;
        
        for (int num : num_list) {
            if (i % 2 == 0) evenSum += num;
            else oddSum += num;
            i++;
        }
        
        return Math.max(oddSum, evenSum);
    }
}
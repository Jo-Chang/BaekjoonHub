class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length, num1 = num_list[len - 2], num2 = num_list[len - 1];
        int[] answer = new int[len + 1];
        
        for (int i = 0; i < len; i++) {
            answer[i] = num_list[i];
        }
        
        answer[len] = num1 < num2 ? num2 - num1 : num2 * 2;
        
        return answer;
    }
}
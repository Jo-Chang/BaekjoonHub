class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int sum = 0, idx = 0;
        
        for (int num : arr) sum += num;
        
        answer = new int[sum];
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                answer[idx++] = arr[i];
            }
        }
        
        return answer;
    }
}
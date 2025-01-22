class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] ops = binomial.split(" ");
        int a = Integer.parseInt(ops[0]), b = Integer.parseInt(ops[2]);
        
        switch (ops[1]) {
            case "+":
                answer = a + b;
                break;
            case "-":
                answer = a - b;
                break;
            case "*":
                answer = a * b;
                break;
            case "/":
                answer = a / b;
                break;
        }
        
        return answer;
    }
}
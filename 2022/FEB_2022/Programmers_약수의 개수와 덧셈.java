class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            // i의 약수 개수를 체크할 변수
            int count = 0;
            // 1부터 i까지 하나하나 나눠보며 약수의 개수를 체크
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            
            // 약수의 개수가 짝수면 더하고
            if (count % 2 == 0) {
                answer += i;
            }
            // 홀수면 뺀다
            else {
                answer -= i;
            }
        }
        
        return answer;
    }
}
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for (int i = 0; i < absolutes.length; i++) {
            // 참이면 그 값 그대로 더한다.
            if (signs[i]) {
                answer += absolutes[i];
            }
            // 그렇지 않으면 음수인 수를 더한다.
            else {
                answer += absolutes[i] * -1;
            }
        }
        
        return answer;
    }
}
class Solution {
    public int solution(int[] numbers) {
        // 0에서 9까지의 합인 45로 시작
        int answer = 45;
        
        // answer 배열에 있는 숫자들을 빼준다.
        for (int i = 0; i < numbers.length; i++) {
            answer -= numbers[i];
        }
        
        return answer;
    }
}
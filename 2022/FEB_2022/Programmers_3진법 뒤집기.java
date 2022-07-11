class Solution {
    public int solution(int n) {
        int answer = 0;
        // 뒤집어진 3진법을 저장하기 위한 문자열
        String reversed = "";
        
        // 뒤집어진 3진법을 계산
        while (n > 0) {
            reversed += Integer.toString(n % 3);
            n /= 3;
        }
        
        // 뒤집어진 3진법 수를 10진법으로 변환
        for (int i = 0; i < reversed.length(); i++) {
            int num = reversed.charAt(i) - '0';
            answer += Math.pow(3, reversed.length() - i - 1) * num;
        }
        
        return answer;
    }
}
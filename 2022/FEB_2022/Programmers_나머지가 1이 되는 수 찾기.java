class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 2부터 n-1까지 반복문을 통해 나머지가 1인 수 i를 찾아 return
        for (int i = 2; i <= n - 1; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        
        return answer;
    }
}
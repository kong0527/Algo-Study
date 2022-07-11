class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;
        
        // 횟수 * 금액 만큼의 값을 갖고 있는 돈에서 빼준다.
        for (int i = 1; i <= count; i++) {
            answer -= price * i;
        }
        
        // 돈이 모자라지 않으면 0을 그렇지 않으면 -1을 곱한 값을 return
        return (answer > 0 ? 0 : answer * -1);
    }
}
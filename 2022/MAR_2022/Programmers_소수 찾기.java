import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        // 숫자가 소수인지 아닌지 저장할 arr 배열
        int arr[] = new int[n+1];
        Arrays.fill(arr, 0);
        // 1은 소수가 아니므로 미리 1을 채운다.
        arr[1] = 1;		

        // 차례로 2의배수, 3의 배수, ...n의 배수인 수들을 1로 소수가 아님을 표시한다.
        for (int i = 2; i <= n; i++) {
                for (int j = 2; i * j <= n; j++) {
                        arr[i * j] = 1;
                }
        }

        // 소수의 개수를 센다.		
        for (int i = 1; i <= n; i++) {
                if (arr[i] != 1) {
                        answer++;
                }
        }
        
        return answer;
    }
}
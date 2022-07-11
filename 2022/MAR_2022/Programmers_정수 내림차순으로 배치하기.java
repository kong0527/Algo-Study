import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        // n을 String 타입으로 변환
        String tmp = Long.toString(n);
        int arr[] = new int[tmp.length()];
        
        // n의 숫자 하나하나를 arr 배열에 저장
        for (int i = 0; i < tmp.length(); i++) {
            arr[i] = tmp.charAt(i) - '0';
        }
        
        // arr 배열을 오름차순으로 정렬
        Arrays.sort(arr);
        tmp = "";
        
        // 숫자를 내림차순으로 tmp에 저장
        for (int i = arr.length - 1; i >= 0; i--) {
            tmp += Integer.toString(arr[i]);
        }
        
        return Long.parseLong(tmp);
    }
}
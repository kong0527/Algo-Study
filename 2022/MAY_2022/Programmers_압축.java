import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        int num = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 사전 초기화
        for (int i = 65; i <= 90; i++) {
            char ch = (char) i;
            hashMap.put(String.valueOf(ch), num++);
        }

        String max = "";

        while (msg.length() > 0) {
            for (int i = 0; i < msg.length(); i++) {
                // 인덱스 0 ~ i 까지 문자열을 자른다.
                String tmp = msg.substring(0, i + 1);
                // 사전에 있는 문자열이면 max 갱신
                if (hashMap.containsKey(tmp)) {
                    max = tmp;
                }

                // 사전에 없는 문자열이면
                else {
                    // 지금까지 나온 제일 긴 사전에 있는 문자열을 arr에 넣고
                    arr.add(hashMap.get(max));
                    // 나오지 않은 현재까지의 문자열을 사전에 새로 넣는다.
                    hashMap.put(tmp, num++);
                    // 사전에서 찾을 수 있는 부분까지 자른다.
                    msg = msg.substring(i);
                    break;
                }

                // 무한 루프 방지를 위해 맨 마지막 문자열까지 탐색하면 msg를 비운다.
                if (i == msg.length() - 1) {
                    msg = "";
                }
            }
        }

        // 맨 마지막에 남아있는 max 문자열 처리
        if (hashMap.containsKey(max)) {
            arr.add(hashMap.get(max));
        }

        else {
            arr.add(num);
        }


        answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        return answer;
    }
}
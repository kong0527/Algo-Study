import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> hashMap = makeHash(want, number);
            boolean flag = true;
            for (int j = i; j < i + 10; j++) {
                String key = discount[j];
                if (hashMap.containsKey(key)) {
                    int value = hashMap.get(key);
                    if (value <= 0) {
                        flag = false;
                        break;
                    }

                    else {
                        hashMap.put(key, --value);
                    }
                }

                else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
        }

        return answer;

    }

    public HashMap<String, Integer> makeHash(String[] want, int[] number) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            hashMap.put(want[i], number[i]);
        }

        return hashMap;
    }
}
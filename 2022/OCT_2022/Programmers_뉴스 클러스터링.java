import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int and = 0;
        int or = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        HashMap<String, Integer> hashMap1 = make(str1);
        HashMap<String, Integer> hashMap2 = make(str2);

        for (String key : hashMap1.keySet()) {
            if (hashMap2.containsKey(key)) {
                and += Math.min(hashMap1.get(key), hashMap2.get(key));
            }

            or += hashMap1.get(key);
        }

        for (String key : hashMap2.keySet()) {
            or += hashMap2.get(key);
        }

        or -= and;

        if (or == 0 && and == 0) {
            return 65536;
        }

        return (int) Math.floor((double) and / or * 65536);
    }

    public static HashMap<String, Integer> make (String s) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length() - 1; i++) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i + 1);

            if (Character.isLetter(ch1) && Character.isLetter(ch2)) {
                String tmp = String.valueOf(ch1) + String.valueOf(ch2);
                if (hashMap.containsKey(tmp)) {
                    int value = hashMap.get(tmp);
                    hashMap.put(tmp, value + 1);
                }

                else {
                    hashMap.put(tmp, 1);
                }
            }
        }

        return hashMap;
    }
}
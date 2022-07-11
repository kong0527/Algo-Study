import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String st = cities[i].toUpperCase();

            // cache hit
            if (cache.remove(st)) {
                answer++;
            }

            // cache miss
            else {
                answer += 5;
                if (cache.size() >= cacheSize) {
                    cache.remove(0);
                }
            }
            cache.add(st);
        }

        return answer;
    }
}
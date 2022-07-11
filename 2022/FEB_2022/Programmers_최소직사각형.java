class Solution {
    public int solution(int[][] sizes) {
        int wmax = 0;
        int hmax = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            // 주어진 직사각형의 가로 세로를 비교해서 더 긴 길이를 width 위치로 옮긴다.
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
                                    
            // width중 제일 긴 값과 height 중 제일 긴 값을 구한다.
            wmax = Math.max(sizes[i][0], wmax);
            hmax = Math.max(sizes[i][1], hmax);                        
        }
                                    
        // wmax와 hmax를 곱한 값을 return
        return wmax * hmax;
    }
}
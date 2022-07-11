class Solution {
    int[] dx = {1, 0, -1};
    int[] dy = {0, 1, -1};    
    
    public int[] solution(int n) {
        int[] answer;

        // 삼각형에 적힐 값들을 저장할 이차원 배열
        int[][] arr = new int[n][n];

        // (0,0)의 값은 1로 고정
        arr[0][0] = 1;
        // 삼각형에 적힐 수의 최댓값 
        int end = n * (n + 1) / 2;
        // 삼각형에 적힐 값
        int count = 2;
        // 다음에 움직일 방향을 정하는 flag
        int direction = 0;
        // 이차원 배열에 값을 적어나갈 좌표
        int x = 1;
        int y = 0;

        while (count <= end) {
            // (x,y)에 현재 값을 적는다.
            arr[x][y] = count++;
            // (n-1, 0)일때, (n-1,y-1)일때, 다음 움직여야 할 자리에 이미 값이 있을 때 방향을 바꾼다.
            if ((x == n - 1 && y == 0) || (x == n - 1 && y == n - 1) || arr[x + dx[direction % 3]][y + dy[direction % 3]] != 0) {
                direction++;
            }
            // 다음 움직일 (x,y) 좌표
            x = x + dx[direction % 3];
            y = y + dy[direction % 3];
        }

        // 일차원 배열에 채워진 삼각형 값들을 채운다.
        answer = new int[end];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }
}
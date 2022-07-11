class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows][columns];

        // 2차원 배열에 주어진 규칙대로 수를 채워 넣는다.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = i * columns + j + 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            // 회전을 몇번할 지 횟수를 구함
            int loop = ((x2 - x1 + 1) + (y2 -y1 + 1)) * 2 - 4;
            // 현재 x,y 좌표를 저장할 변수
            int currentX = x1;
            int currentY = y1;
            // 어느 방향으로 갈지 정할 변수
            int direction = 0;
            // 한 번의 회전에서 가장 작은 수를 저장할 변수
            int min = arr[currentX][currentY];
            // 값을 바꿀 때 이전 값을 저장하고 있을 변수
            int prev = arr[currentX][currentY++];
            for (int j = 0; j < loop; j++) {
                min = Integer.min(min, arr[currentX][currentY]);
                // 시계 방향으로 값을 바꿈
                int tmp = arr[currentX][currentY];
                arr[currentX][currentY] = prev;
                prev = tmp;
                // 사각형의 모서리 부분에서는 방향을 바꿈
                if ((currentX == x1 && currentY == y2) || (currentX == x2 && currentY == y2) || (currentX == x2 && currentY == y1)) {
                    direction++;
                }
                // 다음 좌표 설정
                currentX = currentX + dx[direction];
                currentY = currentY + dy[direction];
            }
            answer[i] = min;
        }

        return answer;
    }
}
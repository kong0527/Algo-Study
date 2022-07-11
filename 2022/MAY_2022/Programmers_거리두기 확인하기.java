class Solution {
    int[] dx = {1, 2, 0, 0, 0, 0, -1, -2, -1, -1, 1, 1};
    int[] dy = {0, 0, -1, -2, 1, 2, 0, 0, -1, 1, 1, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        // places[k]를 5x5크기 이차원 배열로 변환
        for (int k = 0; k < places.length; k++) {
            String[][] tmp = new String[5][5];
            String[] st = places[k];
            for (int i = 0; i < 5; i++) {
                String s = st[i];
                for (int j = 0; j < 5; j++) {
                    tmp[i][j] = String.valueOf(s.charAt(j));
                }
            }

            // 거리두기를 지킨 대기실이면 1
            if (check(tmp)) {
                answer[k] = 1;
            }
        }

        return answer;
    }

    public boolean check(String[][] arr) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // 현재 위치가 P일때만 검사
                if (arr[i][j].equals("P")) {
                    for (int k = 0; k < dx.length; k++) {
                        // 위, 아래, 양옆, 대각선 방향으로 차례로 탐색
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];

                        // 다음 좌표가 범위 안이면 탐색
                        if (nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5) {
                            String next = arr[nextX][nextY];

                            if (next.equals("P")) {
                                // 범위 내에 P가 있을 때 P X 의 경우에 거리두기를 지키는 것
                                //                    X P
                                if (arr[i][nextY].equals("X") && arr[nextX][j].equals("X")) {
                                    continue;
                                }

                                else {
                                    return false;
                                }
                            }

                            // 위, 아래, 양옆을 봤을 때 i,j 위치에서 한 칸 차이나는 곳이 X면 두 칸 차이 나는 곳은 볼 필요가 없다.
                            if (next.equals("X") && k <= 7 && k % 2 == 0) {
                                k++;
                            }

                        }
                    }
                }
            }
        }

        return true;
    }
}
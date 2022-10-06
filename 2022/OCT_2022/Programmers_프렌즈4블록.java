class Solution {
    char[][] game;
    boolean[][] delete;
    int[] dx = {0, 1, 1};
    int[] dy = {1, 0, 1};
    int count;
    
    public int solution(int m, int n, String[] board) {
        boolean flag = true;
        count = 0;
        game = new char[m][n];
        delete = new boolean[m][n];

        for (int i = 0; i < board.length; i++) {
            String tmp = board[i];
            for (int j = 0; j < tmp.length(); j++) {
                game[i][j] = tmp.charAt(j);
            }
        }

        while (flag) {
            flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (game[i][j] != '-' && check(i, j)) {
                        flag = true;
                        delete[i][j] = true;
                        for (int k = 0; k < 3; k++) {
                            delete[i + dx[k]][j + dy[k]] = true;
                        }
                    }
                }
            }

            if (flag) {
                mark();
                for (int j = 0; j < n; j++) {
                    for (int i = m - 2; i >= 0; i--) {
                        if (game[i][j] == '-') {
                            continue;
                        }

                        for (int k = m - 1; k > i; k--) {
                            if (game[k][j] == '-') {
                                game[k][j] = game[i][j];
                                game[i][j] = '-';
                                break;
                            }
                        }
                    }
                }
            }
            delete = new boolean[m][n];
        }

        return count;
    }
    
    public void mark() {
        for (int i = 0; i < game.length; i++) {
            for (int j = 0; j < game[0].length; j++) {
                if (delete[i][j]) {
                    count++;
                    game[i][j] = '-';
                }
            }
        }
    }
    
    public boolean check(int x, int y) {
        char flag = game[x][y];

        for (int i = 0; i < 3; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < game.length && nextY < game[0].length) {
                if (game[nextX][nextY] != flag) {
                    return false;
                }
            }

            else {
                return false;
            }
        }


        return true;
    }
}
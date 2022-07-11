import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        // 바구니를 stack으로 구현
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int x = -1;
            int y = moves[i] - 1;

            for (int j = 0; j < board.length; j++) {
                // 인형이 있을 때까지 아래로 내려간다.
                if (board[j][y] != 0) {
                    x = j;
                    break;
                }
            }

            if (x != -1) {
                // 스택이 비어있지 않고 인형을 터트릴 수 있으면 터트린다.
                if (!stack.isEmpty() && stack.peek() == board[x][y]) {
                    stack.pop();
                    answer += 2;
                }

                // 그렇지 않으면 스택에 넣는다.
                else {
                    stack.push(board[x][y]);
                }
                board[x][y] = 0;
            }
        }


        return answer;
    }
}
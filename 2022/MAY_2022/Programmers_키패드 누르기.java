class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num == 0) {
                num = 11;
            }

            // 1, 4, 7인 경우 왼손으로 누름
            if (num == 1 || num == 4 || num == 7) {
                answer += "L";
                left = num;
            }

            // 3, 6, 9인 경우 오른손으로 누름
            else if (num == 3 || num == 6 || num == 9) {
                answer += "R";
                right = num;
            }

            // 2, 5, 8, 0인 경우 계산 필요
            else {
                // 눌러야 하는 숫자의 x, y좌표 계산
                int targetX = (num - 1) / 3;
                int targetY = (num - 1) % 3;

                // 현재 왼쪽 손의 위치를 x, y좌표로 계산
                int leftX = (left - 1) / 3;
                int leftY = (left - 1) % 3;

                // 현재 오른쪽 손의 위치를 x, y좌표로 계산
                int rightX = (right - 1) / 3;
                int rightY = (right - 1) % 3;

                // 눌러야 하는 숫자에서 왼쪽과 오른쪽 손까지의 거리 계산
                int leftDis = Math.abs(targetX - leftX) + Math.abs(targetY - leftY);
                int rightDis = Math.abs(targetX - rightX) + Math.abs(targetY - rightY);

                // right가 더 짧으면 오른손으로 누른다.
                if (leftDis > rightDis) {
                    answer += "R";
                    right = num;
                }

                // left가 더 짧으면 왼손으로 누른다.
                else if (leftDis < rightDis) {
                    answer += "L";
                    left = num;
                }

                // 같으면 hand 를 따라감
                else {
                    answer += hand.substring(0, 1).toUpperCase();
                    if (hand.substring(0, 1).toUpperCase().equals("R")) {
                        right = num;
                    }

                    else {
                        left = num;
                    }

                }
            }
        }

        return answer;
    }
}
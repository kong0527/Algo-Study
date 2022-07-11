class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        while (true) {
            // a = 4, b = 5일 때 1이 나오는 경우의 수를 막음
            if (Math.abs(a - b) == 1 && (Math.round((float) a / 2) == Math.round((float) b / 2))) {
                break;
            }

            if (a != 1) {
                if (a % 2 == 1) {
                    a++;
                }
                a /= 2;
            }

            if (b != 1) {
                if (b % 2 == 1) {
                    b++;
                }
                b /= 2;
            }

            answer++;
        }

        return answer;
    }
}
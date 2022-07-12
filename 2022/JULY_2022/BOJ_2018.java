import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 연속된 자연수의 합으로 N을 만들 수 있는 경우의 수를 구하는 문제

public class Main {

    public static int solution(int limit, int target) {
        int count = 1;
        int start = 1;
        int end = 1;
        int sum = 1;

        while (end != limit + 1) {
            if (sum == target) {
                count++;
                end++;
                sum += end;
            }

            else if (sum > target) {
                sum -= start;
                start++;
            }

            else {
                end++;
                sum += end;
            }

        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int limit = (int) Math.ceil((float) n /2);

        System.out.println(solution(limit, n));
    }
}
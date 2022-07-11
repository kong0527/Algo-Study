import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 연속된 자연수의 합으로 N을 만들 수 있는 경우의 수를 구하는 문제

public class Main {

    public static int solution(int[] arr, int target) {
        int count = 0;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (true) {
            // sum의 값이 m보다 크면 start 인덱스를 하나 증가시킨다.
            if (sum >= target) {
                sum -= arr[start++];
            }

            // end 인덱스가 마지막 인덱스를 넘어서면 종료
            else if (end == arr.length) {
                break;
            }

            // sum의 값이 m보다 작으면 end 인덱스를 하나 증가시킨다.
            else {
                sum += arr[end++];
            }

            // 찾던 값이라면 count를 증가
            if (sum == target) {
                count++;
            }
        }


        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[(int) Math.ceil((float) n /2)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        System.out.println(solution(arr, n) + 1);
    }
}
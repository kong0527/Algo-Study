import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static long solution(int[] arr) {
        long answer = 1;
        // 배열을 오름차순으로 정렬
        Arrays.sort(arr);
        // 가장 큰 값까지 에라토스테네스의 체 방법으로 소수를 구할 것이다.
        int max = arr[arr.length - 1];
        int[] isPrime = new int[max + 1];
        isPrime[1] = 1;
        int count = 0;

        // 에라토스테네스의 체 방법으로 소수 판별
        for (int i = 2; i < isPrime.length; i++) {
            for (int j = 2; i * j < isPrime.length; j++) {
                isPrime[i * j] = 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            // 소수이면
            if (isPrime[arr[i]] != 1) {
                // 최소공배수를 따로 구할 필요 없이 그냥 곱해주면 된다.
                answer *= arr[i];
                // 중복 제거 방지
                isPrime[arr[i]] = 1;
                count++;
            }
        }

        // 소수가 하나도 없으면 -1을 반환
        if (count == 0) {
            return -1;
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num];
            String[] st = br.readLine().split(" ");

            for (int i = 0; i < st.length; i++) {
                arr[i] = Integer.parseInt(st[i]);
            }

            System.out.println(solution(arr));
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int solution(int[] arr) {
        int answer = 0;
        // 받아온 배열을 정렬
        Arrays.sort(arr);
        int[] sorted = new int[arr.length];
        int x = 0;
        int y = 0;

        // 작은 값, 그 다음 작은 값을 각각 배열의 처음과 끝에 넣는 것을 반복
        while (x < arr.length) {
            if (arr.length % 2 == 1 && x == arr.length - 1) {
                break;
            }
            sorted[y] = arr[x];
            sorted[arr.length - y - 1] = arr[x + 1];
            x += 2;
            y++;
        }

        if (arr.length % 2 == 1) {
            sorted[arr.length / 2] = arr[arr.length - 1];
        }

        for (int i = 0; i < sorted.length; i++) {
            if (i == sorted.length - 1) {
                answer = Math.max(answer, Math.abs(sorted[i] - sorted[0]));
            }

            else {
                answer = Math.max(answer, Math.abs(sorted[i] - sorted[i + 1]));
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int size = Integer.parseInt(br.readLine());
            int[] arr = new int[size];
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                arr[j] = Integer.parseInt(st[j]);
            }
            System.out.println(solution(arr));
        }
    }
}
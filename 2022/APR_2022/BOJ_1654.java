import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int k = Integer.parseInt(st[0]);
        int n = Integer.parseInt(st[1]);
        int[] arr = new int[k];
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        max++;

        long min = 0;
        long mid = 0;

        while (min < max) {
            // 범위 내에서의 중간값
            mid = (max + min) / 2;
            long count = 0;

            // mid로 랜선을 총 몇 개 만들 수 있는지 구한다.
            for (int i = 0; i < k; i++) {
                count += arr[i] / mid;
            }

            // n보다 적게 만들어졌다면 길이를 줄여야 한다.
            if (count < n) {
                max = mid;
            }

            // 아니라면 최소 길이를 늘린다.
            else {
                min = mid + 1;
            }
        }

        System.out.println(--min);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int k = Integer.parseInt(st[1]);
        int[] arr = new int[n];
        st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }
        int start = 0;
        int end = start + k;
        int max = Integer.MIN_VALUE;

        while (start <= n - k) {
            int sum = 0;
            // 시작점부터 연속 k일만큼 더해준다.
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            // 지금까지의 max 값과 비교
            max = Math.max(max, sum);
            // 시작점과 끝점 갱신
            start++;
            end = start + k;
        }

        System.out.println(max);
    }
}

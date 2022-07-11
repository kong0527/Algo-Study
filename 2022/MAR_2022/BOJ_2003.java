import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int[] arr = new int[n];
        st = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        int start = 0;
        int end = 0;
        long sum = 0;
        int count = 0;

        while (true) {
            // sum의 값이 m보다 크면 start 인덱스를 하나 증가시킨다.
            if (sum >= m) {
                sum -= arr[start++];
            }
            
            // end 인덱스가 마지막 인덱스를 넘어서면 종료
            else if (end == n) {
                break;
            }

            // sum의 값이 m보다 작으면 end 인덱스를 하나 증가시킨다.
            else {
                sum += arr[end++];
            }

            // 찾던 값이라면 count를 증가
            if (sum == m) {
                count++;
            }
        }

        System.out.println(count);
    }
}
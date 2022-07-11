import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String st[] = br.readLine().split(" ");
        int start = 0;
        int end = n - 1;
        int count = 0;
        int x = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        Arrays.sort(arr);

        while (start < end) {
            sum = arr[start] + arr[end];
            if (sum == x) {
                count++;
            }

            if (sum >= x) {
                end--;
            }

            else {
                start++;
            }
        }

        System.out.println(count);

    }
}

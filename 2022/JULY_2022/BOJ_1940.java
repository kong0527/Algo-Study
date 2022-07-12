import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int solution(int[] arr, int m) {
        int count = 0;
        int start = 0;
        int end = arr.length - 1;
        Arrays.sort(arr);

        while (start < end) {
            if (arr[start] + arr[end] < m) {
                start++;
            }

            else if (arr[start] + arr[end] > m) {
                end--;
            }

            else {
                count++;
                start++;
                end--;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int m = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        System.out.println(solution(arr, m));
    }
}
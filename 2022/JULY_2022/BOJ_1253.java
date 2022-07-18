
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int solution(int[] arr) {
        int count = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int s = 0;
            int e = arr.length - 1;

            while (s < e) {
                if (arr[s] + arr[e] == arr[i]) {
                    if (s != i && e != i) {
                        count++;
                        break;
                    }
                    else if (s == i){
                        s++;
                    }
                    else if (e == i) {
                        e--;
                    }
                }
                else if (arr[s] + arr[e] < arr[i]) {
                    s++;
                }

                else {
                    e--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        System.out.println(solution(arr));
    }

}
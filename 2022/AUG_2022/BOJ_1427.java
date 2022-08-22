import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[maxIdx] < arr[j]) {
                    maxIdx = j;
                }
            }
            swap(arr, i, maxIdx);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        int[] arr = new int[st.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = st.charAt(i) - '0';
        }
        solution(arr);
        for (int num : arr) {
            System.out.print(num);
        }
    }
}
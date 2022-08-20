import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static String solution(int n, int[] arr) {
        int num = 1;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int target = arr[i];

            while (num <= target) {
                stack.push(num++);
                sb.append("+").append("\n");
            }

            if (stack.peek() == target) {
                stack.pop();
                sb.append("-").append("\n");
            }

            else {
                return "NO";
            }
        }

        if (!stack.isEmpty()) {
            return "NO";
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(n, arr));
    }
}
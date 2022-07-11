import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            // 문자열 길이가 홀수면 무조건 NO
            if (s.length() % 2 != 0) {
                System.out.println("NO");
            }
            else {
                System.out.println(check(s));
            }
        }
    }

    public static String check(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // ( 일경우 stack에 넣는다.
            if (ch == '(') {
                stack.push(ch);
            }

            // )인데 stack이 비어있으면 NO
            else if (stack.isEmpty()) {
                return "NO";
            }

            // (와 ) 짝 완성
            else {
                stack.pop();
            }

        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}

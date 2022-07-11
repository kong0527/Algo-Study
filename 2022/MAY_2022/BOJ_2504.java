import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static int solution(String st) {
        int answer = 0;
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < st.length(); i++) {
            String s = String.valueOf(st.charAt(i));
            // 여는 괄호거나 숫자이면 그대로 스택에 넣는다.
            if (s.equals("(") || s.equals("[") ||isNum(s)) {
                stack.push(s);
            }

            // 닫는 괄호라면
            else {
                // 스택이 비어있으면 올바르지 않은 괄호
                if (stack.isEmpty()) {
                    return 0;
                }

                // 괄호 사이에 숫자가 있으면 그 숫자를 빼냄
                int num = 1;
                if (isNum(stack.peek())) {
                    num = Integer.valueOf(stack.pop());
                }

                // 숫자를 빼고 나서 스택이 비어있으면 올바르지 않은 괄호
                if (stack.isEmpty()) {
                    return 0;
                }

                // 들어온 문자열이 ) 이면
                if (s.equals(")")) {
                    // 스택에 있던 문자열이 ( 라면 꺼내고 숫자 계산을 한다.
                    if (stack.peek().equals("(")) {
                        stack.pop();
                        num *= 2;
                    }
                    // 다른 문자열이면 올바르지 않은 괄호
                    else {
                        return 0;
                    }
                }

                // 들어온 문자열이 ] 이면
                else if (s.equals("]")) {
                    // 스택에 있던 문자열이 [ 라면 꺼내고 숫자 계산을 한다.
                    if (stack.peek().equals("[")) {
                        stack.pop();
                        num *= 3;
                    }

                    else {
                        return 0;
                    }
                }

                // 스택이 비어있지 않고 숫자라면 num에 더해준다.
                if (!stack.isEmpty()) {
                    if (isNum(stack.peek())) {
                        num += Integer.valueOf(stack.pop());
                    }
                }
                // 스택에 그 값을 넣는다.
                stack.push(String.valueOf(num));
            }
        }

        // for 문을 끝나고서 stack이 비어있지 않으면
        if (!stack.isEmpty()) {
            // 숫자인 경우에는 정답 값이 들어있는 경우이므로 꺼내면 되고
            if (isNum(stack.peek())) {
                answer += Integer.valueOf(stack.pop());
            }
            // 다른 값이 들어있으면 올바르지 않은 괄호이므로 0을 반환
            else {
                return 0;
            }
        }

        // 숫자를 뺴고 나서도 스택이 비어있지 않으면 올바르지 않은 괄호
        if(!stack.isEmpty()) {
            return 0;
        }

        return answer;
    }

    public static boolean isNum (String s) {
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!('0' <= ch && ch <= '9')) {
                return false;
            }
        }

        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        System.out.println(solution(st));
    }
}
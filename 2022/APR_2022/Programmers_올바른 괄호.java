import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // ( 이면 스택에 넣는다.
            if (ch == '(') {
                stack.push(ch);
            }

            else {
                // ) 이고 스택이 비어있지 않으면 스택에서 값을 꺼낸다.
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                // 비어있으면 잘못된 문자열이므로 false를 반환한다.
                else {
                    return false;
                }
            }
        }

        // 스택이 비어있으면 올바른 괄호, 아니면 잘못된 괄호
        return stack.isEmpty() ? true : false;
    }
}
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int size = s.length();

        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(0);
            // s의 길이만큼 회전
            s = s.substring(1) + tmp;

            // 올바른 괄호이면 answer 증가
            if (check(s)) {
                answer++;
            }
        }

        return answer;
    }
    
    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 여는 괄호들이면 스택에 담는다
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // 닫는 괄호이면 짝인 여는 괄호를 빼낸다. 빼낼수 없다면 올바르지 않은 괄호
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                else {

                    if (ch == ')') {
                        if (stack.peek() == '(') {
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                    }

                    else if (ch == '}') {
                        if (stack.peek() == '{') {
                            stack.pop();
                        }
                        else {
                            return false;
                        }
                    }

                    else {
                        if (stack.peek() == '[') {
                            stack.pop();
                        }

                        else {
                            return false;
                        }
                    }
                }
            }
        }

        // 마지막 문자열까지 봤을 때 스택이 비어있으면 올바른 괄호
        return stack.isEmpty() ? true : false;
    }
}
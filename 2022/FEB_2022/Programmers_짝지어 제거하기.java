import java.util.*;

class Solution
{
    public int solution(String s)
    {
        // 주어진 문자열 하나하나를 저장할 stack 
        Stack<Character> stack = new Stack<>();
         
        for(char c : s.toCharArray()) {
            // 스택이 비어있지 않을 때 이전 문자열과 현재 문자열이 같으면 스택에서 꺼낸다.
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            
            // 스택이 비어있거나 문자열이 같지 않으면 스택에 넣는다.
            else {
                stack.push(c);
            }
        }
         
        return stack.isEmpty() ? 1 : 0;
    }
}
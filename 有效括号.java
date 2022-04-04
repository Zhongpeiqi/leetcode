package 力扣;

import java.util.Stack;

public class 有效括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for(char c :ch){
            if(c=='{'){
                stack.push('}');
            }else if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(stack.isEmpty()||stack.pop()!=c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}

//https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        ArrayDeque<Character> stack = new ArrayDeque<>(len);
        for(int i = 0 ; i < len ; i++) {
            char curr = s.charAt(i);
            if(curr == '(' || curr == '[' || curr == '{') 
                stack.push(curr);
            else if(!stack.isEmpty()) {
                if(curr == ')' && stack.peek() != '(')
                    return false;
                else if(curr == ']' && stack.peek() != '[')
                    return false;
                else if(curr == '}' && stack.peek() != '{')
                    return false;
                else
                    stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
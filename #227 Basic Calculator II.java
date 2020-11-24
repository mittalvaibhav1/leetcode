//https://leetcode.com/problems/basic-calculator-ii/
class Solution {
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack<>(); // 22 - 3 * 5;
        int currNum = 0;
        char currOp = '+';
        int i = 0;
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    currNum = currNum * 10 + (s.charAt(i) - '0') ;
                    i++;
                }
            }
            if(i < s.length() && s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if(currOp == '*') {
                stack.push(stack.pop() * currNum);
                currNum = 0;
            }
            if(currOp =='/') {
                stack.push(stack.pop() / currNum);
                currNum = 0;
            }
            if( i < s.length() && !Character.isDigit(s.charAt(i))) {
               if(currOp == '+') {
                   stack.push(currNum);
               }
               else if(currOp == '-') {
                   stack.push(-currNum);
               }
               currOp = s.charAt(i);
               currNum = 0;
               i++; 
            }
        }
        int res = 0;
        if(currNum != 0) {
            res = currOp == '-' ? -currNum : currNum;
        }
        
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
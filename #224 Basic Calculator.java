//https://leetcode.com/problems/basic-calculator/
class Solution {
    public int calculate(String s) {
        s = s.trim();
        int len = s.length();
        ArrayDeque<String> stack = new ArrayDeque(len);
        int i = len - 1;
        while(i >= 0) {
            if(s.charAt(i) == ' '){
                i--;
                continue;
            } 
            else if(s.charAt(i) == ')') {
                stack.push(")");
                i--;
            }
            else if(Character.isDigit(s.charAt(i))) {
                int num = 0 , step = 0;
                while(i >= 0 && Character.isDigit(s.charAt(i))) {
                    num += (s.charAt(i) - '0') * Math.pow(10,step++);
                    i--;
                }
                stack.push(String.valueOf(num));
            }
            else if(s.charAt(i) == '('){
                int res = eval(stack);
                stack.push(String.valueOf(res));
                i--;
            }
            else {
                stack.push(String.valueOf(s.charAt(i--)));
            }
        }
        //System.out.println(stack);
        return eval(stack);
    }
    public int eval(ArrayDeque<String> stack) {
        int res = 0;
        if(!stack.isEmpty()) {
            res = Integer.parseInt(stack.pop());
        }
        while(!stack.isEmpty() && !(stack.peek() == ")")) {
            String sign = stack.pop();
            if(sign.equals("+")) {
                res += Integer.parseInt(stack.pop());
            }
            else {
                res -= Integer.parseInt(stack.pop());
            }
        }
        if(!stack.isEmpty()) {
            stack.pop();
        }
        return res;
    }
}
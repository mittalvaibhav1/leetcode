//https://leetcode.com/problems/decode-string
class Solution {
    public String decodeString(String s) {
        Stack<Integer> k = new Stack<>();
        Stack<String> es = new Stack<>();
        StringBuilder res = new StringBuilder("");
        int i = 0;
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                int num = 0;
                while(Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                k.push(num);
            }
            else if(s.charAt(i) == '[') {
                es.push(res.toString());
                res.setLength(0);
                i++;
            }
            else if(s.charAt(i) == ']') {
                StringBuilder tmp = new StringBuilder(es.pop());
                int n = k.pop();
                for(int j = 0 ; j < n ; j++) {
                    tmp.append(res);
                }
                res = tmp;
                i++;
            }
            else {
                res.append(s.charAt(i++));
            }
        }
        return res.toString();
    }
}
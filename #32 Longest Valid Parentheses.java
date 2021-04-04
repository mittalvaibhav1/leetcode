//https://leetcode.com/problems/longest-valid-parentheses/
// M1 using Stack, O(n) - space, time.

class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0, len = 0, maxlen = 0;
        int lastIndex = -1;
        int slen = s.length();
        ArrayDeque<Integer> idxs = new ArrayDeque<>(slen);
        for(int i = 0 ; i < slen ; i++) {
            char curr = s.charAt(i);
            if(curr == '(') {
                open++;
                idxs.push(i);
            }
            else {
                if(open == 0) {
                    len = 0;
                }
                else {
                    len += 2;
                    open--;
                    idxs.pop();
                }
            }
            if(open != 0) 
                maxlen = Math.max(maxlen, i - (idxs.peek()));
            else
                maxlen = Math.max(len, maxlen);
        }
        return maxlen;
    }
}
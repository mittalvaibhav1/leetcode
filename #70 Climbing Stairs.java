//https://leetcode.com/problems/climbing-stairs/
class Solution {
    public int climbStairs(int n) {
        int res = 0;
        int n1 = 0;
        int n2 = 1;
        while(n-- > 0) {
            res = n1 + n2;
            n1 = n2;
            n2 = res;
        }
        return res;
    }
}
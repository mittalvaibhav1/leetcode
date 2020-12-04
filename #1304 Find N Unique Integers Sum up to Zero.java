//https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int start = -1 * n / 2;
        for(int i = 0 ; i < n ; i++) {
            if(n % 2 == 0 && start == 0) start++;
            res[i] = start++;
        }
        return res;
    }
}
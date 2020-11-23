//https://leetcode.com/problems/house-robber
class Solution {
    public int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + nums[i] ,prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}
//https://leetcode.com/problems/longest-continuous-increasing-subsequence/
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        int curr = nums[0];
        int currLen = 1;
        int maxLen = 1;
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] > curr ) {
               currLen++; 
            }
            else {
                maxLen = Math.max(currLen,maxLen);
                currLen = 1;
            }
            curr = nums[i];
        }
        maxLen = Math.max(currLen,maxLen);
        return maxLen;
    }
}
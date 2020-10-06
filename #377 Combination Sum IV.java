//https://leetcode.com/problems/combination-sum-iv/
class Solution {
    public int dp[];
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp,-1);
         return helper(nums,target,0);
    }
    public int helper(int[] nums , int target, int sum) {
        if(sum > target) {
            return 0;
        }
        if(sum == target) {
            return 1;
        }
        if(dp[sum] != -1) {
            return dp[sum];
        }
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(sum + nums[i] <= target) {
                sum += nums[i];
                count+=helper(nums,target,sum);
                sum -= nums[i];
            }
        }
        return dp[sum]=count;
    }
}
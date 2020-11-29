//https://leetcode.com/problems/partition-equal-subset-sum/
//M1 11ms
class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false;
        memo = new Boolean[nums.length + 1][(sum / 2) + 1];
        return helper(nums , sum / 2 , nums.length - 1);
    }
    public boolean helper(int[] nums , int target , int idx) {
        if(target == 0) return true;
        if(target < 0 || idx == 0) return false;
        if(memo[idx][target] != null) return memo[idx][target];
        boolean res = helper(nums,target - nums[idx] , idx -1) || helper(nums,target, idx -1);
        memo[idx][target] = res;
        return res;
    }
}
//M2 3ms
class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        memo = new Boolean[nums.length + 1][target + 1];
        return helper(nums , target , 0 , 0);
    }
    public boolean helper(int[] nums , int target , int sum , int idx) {
        if(target == sum) return true;
        if(sum > target) return false;
        if(memo[idx][target] != null) return memo[idx][target];
        for(int i = idx ; i < nums.length ; i++) {
            if(sum + nums[i] <= target) {
                boolean res = helper(nums,target,sum + nums[i],i + 1);
                memo[idx][target] = res;
                if(res) return res;
            }
        }
        return false;
    }
}
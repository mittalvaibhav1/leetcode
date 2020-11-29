//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        int max = 0;
        for(int num : nums){
            totalSum += num;
            max = Math.max(max,num);
        }
        if(totalSum % k != 0 || max > totalSum / k) return false;
        return helper(nums , k , 0 , totalSum / k , new boolean[nums.length] , 0);
    }
    public boolean helper(int nums[],int k , int sum , int target , boolean[] used , int idx) {
        if(k == 0) return true;
        if(sum == target) {
            return helper(nums, k - 1 , 0 , target , used , 0);
        }
        for(int i = idx ; i < nums.length ; i++) {
            if(!used[i] && sum + nums[i] <= target) {
                used[i] = true;
                if(helper(nums , k , sum + nums[i] , target , used , i + 1)) return true;
                used[i] = false;
            }
        }
        return false;
    }
}
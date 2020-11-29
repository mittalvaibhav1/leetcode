//https://leetcode.com/problems/maximum-sum-circular-subarray/
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int currMin = nums[0];
        int currMax = nums[0];
        int totalSum = nums[0];
        for(int i = 1 ; i < nums.length  ; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            currMin = Math.min(currMin + nums[i], nums[i]);
            maxSum = Math.max(maxSum , currMax);
            minSum = Math.min(minSum , currMin);
            totalSum += nums[i];
        }
        return totalSum == minSum ? maxSum : Math.max(totalSum - minSum , maxSum);
    }
}
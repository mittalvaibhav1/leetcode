//https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
//M1 3 ms
class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for(int num : nums) totalSum += num;
        if(totalSum < x) return -1;
        if(totalSum == x) return nums.length;
        int targetSum = totalSum - x;
        int currentSum = 0;
        int windowStart = 0;
        int res = -1;
        for(int i = 0 ; i < nums.length ; i++) {
            currentSum += nums[i];
            if(currentSum > targetSum) {
                while(currentSum > targetSum &&  windowStart <= i) {
                    currentSum -= nums[windowStart++];
                }
            }
            if(targetSum == currentSum) {
                res = Math.max(res, i - windowStart + 1);
            }
        }
        return res == -1 ? -1 : nums.length - res;
    }
}
// M2 63 ms
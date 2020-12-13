//https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int rsum = 0, lsum = 0;
        for(int num : nums) rsum += num;
        for(int i = 0 ; i < len ; i++) {
            rsum -= nums[i];
            lsum += nums[i];
            res[i] = (rsum - (len - i - 1) * nums[i]) + ((i + 1) * nums[i] - lsum);
        }
        return res;
    }
}
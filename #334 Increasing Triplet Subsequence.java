//https://leetcode.com/problems/increasing-triplet-subsequence/
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if(len < 3) return false;
        int[] right = new int[len];
        right[len - 1] = nums[len - 1];
        for(int i = len - 2 ; i >= 0 ; i--) {
            right[i] = Math.max(nums[i], right[i + 1]);
        }
        int min = nums[0];
        for(int i = 1 ; i < len - 1 ; i++) {
            if(min < nums[i] && nums[i] < right[i]) return true;
            min = Math.min(nums[i], min);
        }
        return false;
    }
}
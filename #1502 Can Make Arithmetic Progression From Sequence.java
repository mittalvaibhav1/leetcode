//https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
class Solution {
    public boolean canMakeArithmeticProgression(int[] nums) {
        Arrays.sort(nums);
        int d = nums[1] - nums[0];
        for(int i = 2 ; i < nums.length ; i++) {
            if(nums[i] - nums[i - 1] != d) {
                return false;
            }
        }
        return true;
    }
}
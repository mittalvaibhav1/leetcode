//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = nums[0];
        while(low <= high) {
            int mid = (low + high) / 2;
            boolean left = nums[mid] >= nums[0];
            if(left) {
                low = mid + 1;
            }
            else {
                min = Math.min(min,nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}
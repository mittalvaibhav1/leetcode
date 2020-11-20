//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high && nums[low] == nums[high] ) {
            high--;
        }
        while(low <= high) {
            int mid = (low + high) / 2;
            int num = nums[mid] < nums[0] == target < nums[0] ? nums[mid] : target < nums[0] ?                   Integer.MIN_VALUE : Integer.MAX_VALUE;
            if(num < target) {
                low = mid + 1;
            }
            else if(num > target) {
                high = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
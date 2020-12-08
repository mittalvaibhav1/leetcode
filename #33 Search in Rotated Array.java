//https://leetcode.com/problems/search-in-rotated-sorted-array/
// M1 O(n)
class Solution {
    public int search(int[] nums, int target) {
        int k = 0;
        for(int i : nums) {
            if(i == target) return k;
            k++;
        }
        return -1;
    }
}
// M2 O(Logn)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int num =  nums[mid] < nums[0] == target < nums[0] ? nums[mid] : target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if(num < target) {
                left = mid + 1;
            }
            else if(num > target) {
                right = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
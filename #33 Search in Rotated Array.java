//https://leetcode.com/problems/search-in-rotated-sorted-array/
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
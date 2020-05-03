//https://leetcode.com/problems/single-number/
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0; // O(n) time and O(1) space complexity
        for(int i = 0; i< nums.length ; i++)
        {
            res^=nums[i]; // Doing X-OR of all the element to find the one occuring odd number of times.
        }
        return res;
    }
}
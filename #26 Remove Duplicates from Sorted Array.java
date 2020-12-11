//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while(i < nums.length) {
            int curr = nums[i];
            while(i < nums.length &&  nums[i] == curr) {
                i++;
            }
            nums[j++] = curr;
        }
        return j;
    }
}
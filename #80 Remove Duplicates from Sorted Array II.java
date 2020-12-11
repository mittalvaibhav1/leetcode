//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while(i < nums.length) {
            int curr = nums[i];
            while(i + 2 < nums.length && nums[i + 2] == curr) {
                i++;
            }
            i = nums[i] == curr ? i + 1 : i;
            nums[j++] = curr;
        }
        return j;
    }
}
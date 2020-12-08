//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] map = new int[101];
        int res[] = new int[nums.length];
        for(int i : nums) {
            map[i]++;
        }
        for(int i = 0 ; i < res.length ; i++) {
            res[i] = getCount(map,nums[i]);
        }
        return res;
    }
    public int getCount(int[] map , int x) {
        int count = 0;
        for(int i = x - 1 ; i >= 0 ; i--) {
            count += map[i];
        }
        return count;
    }
}
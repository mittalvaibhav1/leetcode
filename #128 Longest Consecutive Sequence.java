//https://leetcode.com/problems/longest-consecutive-sequence/
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int ans  = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++) {
            if(nums[i] != nums[i+1]) {
                if(nums[i] == nums[i+1] - 1) {
                    count++;
                }
                else {
                    ans = Math.max(count,ans);
                    count = 1;
                }
            }      
        }
        ans = Math.max(count,ans);
        return ans;
    }
}
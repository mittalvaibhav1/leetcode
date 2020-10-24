//https://leetcode.com/problems/longest-consecutive-sequence/
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i : nums) {
            set.add(i);
        }
        int count = 1;
        int ans  = 0;
        int prev = set.first();
        for(int i : set) {
            if(i == prev + 1) {
                count++;
            }
            else {
                ans = Math.max(count,ans);
                count = 1;
            }
            prev = i;
        }
        ans = Math.max(count,ans);
        //System.out.println(set);
        return ans;
    }
}
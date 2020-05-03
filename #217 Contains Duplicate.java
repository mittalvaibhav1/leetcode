//https://leetcode.com/problems/contains-duplicate/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(s.contains(nums[i]))
                return true;
            else
                s.add(nums[i]); //O(n) time and space complexity
        }
        return false;
    }
}
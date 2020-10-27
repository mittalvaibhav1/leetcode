//https://leetcode.com/problems/132-pattern/
class Solution {
    public boolean find132pattern(int[] nums) {
        TreeMap<Integer,Integer> map1 = new TreeMap<Integer,Integer>();
        for(int i = 1 ; i < nums.length ; i++) {
            map1.put(nums[i],map1.getOrDefault(nums[i],0) + 1);
        }
        int minLeft = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
            int val = map1.get(nums[i])-1;
            if(val == 0) map1.remove(nums[i]);
            else map1.put(nums[i],val);
            if(nums[i] > minLeft && map1.subMap(minLeft+1,nums[i]).size()!=0) return true;
            minLeft = Math.min(minLeft,nums[i]);
        }
        return false;
    }
}
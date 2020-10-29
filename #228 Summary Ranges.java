//https://leetcode.com/problems/summary-ranges/
class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0) return new ArrayList<String>();
        List<String> res = new LinkedList<String>();
        int intervalStart = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] != nums[i-1] + 1) {
                if(intervalStart != nums[i-1])
                    res.add(new StringBuilder().append(intervalStart).append("->").append(nums[i-1]).toString());
                else
                    res.add(String.valueOf(nums[i-1]));
                intervalStart = nums[i];
            }
        }
        if(intervalStart != nums[nums.length -1])
            res.add(new StringBuilder().append(intervalStart).append("->").append(nums[nums.length -1]).toString());
        else
            res.add(String.valueOf(nums[nums.length -1]));
        return res;
    }
}
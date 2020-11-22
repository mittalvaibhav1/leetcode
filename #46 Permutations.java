//https://leetcode.com/problems/permutations/submissions/
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        ArrayList<Integer> tmp = new ArrayList<>(nums.length);
        helper(nums,tmp);
        return res;
    }
    public void helper(int[] nums, ArrayList<Integer> tmp) {
        if(tmp.size() == nums.length) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++) {
            if(tmp.contains(nums[i])) continue;
            tmp.add(nums[i]);
            helper(nums , tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
    
}
//https://leetcode.com/problems/permutations-ii/
// M1 31ms
class Solution {
    HashSet<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new HashSet<>();
        helper(nums,new LinkedList<Integer>(), new boolean[nums.length]);
        return new ArrayList(res);
    }
    public void helper(int[] nums, LinkedList<Integer> tmp, boolean[] used) {
        if(tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        }
        else {
            for(int i = 0 ; i < nums.length ; i++) {
                if(used[i]) continue;
                used[i] = true;
                tmp.addLast(nums[i]);
                helper(nums,tmp,used);
                used[i] = false;
                tmp.removeLast();
            }
        }
    }
}
// M2 1 ms
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res = new LinkedList<>();
        helper(nums,new LinkedList<Integer>(), new boolean[nums.length]);
        return res;
    }
    public void helper(int[] nums, LinkedList<Integer> tmp, boolean[] used) {
        if(tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        }
        else {
            for(int i = 0 ; i < nums.length ; i++) {
                if(used[i]) continue;
                if(i > 0  && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i] = true;
                tmp.addLast(nums[i]);
                helper(nums,tmp,used);
                used[i] = false;
                tmp.removeLast();
            }
        }
    }
}
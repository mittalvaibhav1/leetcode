//https://leetcode.com/problems/combination-sum-ii/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,res,curr,0,-1);
        return res;
    }
    public void backtrack(int[] candidates , int target , List<List<Integer>> res, LinkedList<Integer> curr , int sum, int index) {
        if(sum > target) {
            return;
        }
        if(sum == target) {
            res.add(new LinkedList(curr));
            return;
        }
        for(int j = index+1; j <candidates.length ; j++ ) {
            if(j > index+1 &&candidates[j] ==candidates[j-1]){
                continue;
            }
            if(sum+candidates[j] <=target) {
                sum += candidates[j];
                curr.addLast(candidates[j]);
                backtrack(candidates,target,res,curr,sum,j);
                sum -= candidates[j];
                curr.removeLast();
            }
            else {
                break;
            }
        }
    }
}
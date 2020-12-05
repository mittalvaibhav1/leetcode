//https://leetcode.com/problems/next-greater-element-ii/
class Solution {
    class Pair {
        int val;
        int idx;
        public Pair(int val,int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    public int[] nextGreaterElements(int[] nums) {
        int res[] = new int[nums.length];
        Arrays.fill(res,-1);
        if(nums.length == 0) return res;
        ArrayDeque<Pair> stack = new ArrayDeque<>(nums.length);
        boolean second = false;
        for(int i  = 0 ; i < nums.length ; i++) {
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                res[stack.pop().idx] = nums[i];
            }
            stack.push(new Pair(nums[i],i));
            if(!second && i == nums.length - 1) {
                i = -1;
                second = true;
            }
        }
        return res;
    }
}
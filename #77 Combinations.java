//https://leetcode.com/problems/combinations/
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new LinkedList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        helper(n,k,tmp,1);
        return res;
    }
    public void helper(int n, int k , LinkedList<Integer> tmp, int start) {
        if(k == 0) { 
            res.add(new ArrayList(tmp));
        }
        else {
            for(int i = start ; i <= n - k + 1 ; i++) {
                tmp.addLast(i);
                helper(n,k-1,tmp,i+1);
                tmp.removeLast();
            }
        }
    }
}
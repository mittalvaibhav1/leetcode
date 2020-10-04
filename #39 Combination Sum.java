//https://leetcode.com/problems/combination-sum
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> temp = new LinkedList<>();
        Arrays.sort(candidates);
        b(candidates,0,target,temp,0);
        return res;
    }
    public void b(int[] c ,int i,int t,LinkedList<Integer> tmp, int s) {
        if(s == t) { 
            res.add((List<Integer>) tmp.clone());
            //System.out.println(res);
            return;
        }
        if(s > t) {
            return;
        }
        
        for(int j = i ; j < c.length ; j++) {
            if(s+c[j] <= t) {
                s += c[j];
                tmp.add(c[j]);
                //System.out.println(tmp);
                b(c,j,t,tmp,s);
                tmp.remove(new Integer(c[j]));
                s -= c[j];
            }
            else {
                break;
            }
        }
        return;
    }
}
//https://leetcode.com/problems/combination-sum-iii/
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> tmp = new LinkedList<>();
        h(tmp,1,k,n,0,0);
        return res;
    }
    public void h(LinkedList<Integer> tmp,int i,int k,int n,int s,int c) {
        
        if(s == n && c == k) {
            res.add(new LinkedList(tmp));
            return;
        }
        if(s >= n || c >= k ) {
            return;
        }
        for(int j = i ; j < 10 ; j++) {
            if(s+j <= n && c <= k) {
                s+=j;
                tmp.addLast(j);
                h(tmp,j+1,k,n,s,c+1);
                s-=j;
                tmp.removeLast();
            }
            else {
                break;
            }
        }
        return;
    }
}
//https://leetcode.com/problems/partition-labels/
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        HashMap<Character , Integer> map  = new HashMap<>();
        for(int i  = 0 ; i < S.length() ; i++) {
            map.put(S.charAt(i) , i);
        }
        int dist = 0;
        int len  = 0;
        for(int i  = 0 ; i < S.length() ; i++) {
            dist  = Math.max(map.get(S.charAt(i)) , dist);
            len++;
            if(dist == i) {
                res.add(len);
                len = 0;
            }
        }
        return res;
    }
}
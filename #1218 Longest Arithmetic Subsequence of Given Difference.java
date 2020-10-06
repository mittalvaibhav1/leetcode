//https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
       HashMap<Integer,Integer> map = new HashMap<>();
        int max = 1;
       for(int i : arr) {
           int c = map.getOrDefault(i-difference,0)+1;
           map.put(i,c);
           max = Math.max(max,c);
       } 
        return max;
    }
}
//https://leetcode.com/problems/kth-missing-positive-number/
class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr) {
            set.add(i);
        }
        int val = 1;
        while(true) {
            if(!set.contains(val)) 
                k--;
            if(k == 0) return val;
            val++;
        }
    }
}
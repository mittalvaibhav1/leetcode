//https://leetcode.com/problems/global-and-local-inversions/
//O(N^2) 448ms(Optimised)
class Solution {
    public boolean isIdealPermutation(int[] A) {
        int local = 0;
        int global = 0;
        int[] cache = new int[A.length];
        cache[A[0]]++;
        for(int i = 1 ; i < A.length ; i++) {
            global += getCount(cache,A[i]);
            local += A[i-1] > A[i] ? 1 : 0;
            cache[A[i]]++;
        }
        return local == global;
    }
    public int getCount(int[] cache, int val) {
        int count = 0;
        for(int i = val + 1 ; i < cache.length ; i++) {
            count += cache[i];
        }
        return count;
    }
}
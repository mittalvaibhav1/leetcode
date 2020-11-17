//https://leetcode.com/problems/longest-mountain-in-array/
class Solution {
    public int longestMountain(int[] A) {
        if(A.length < 3) return 0;
        int i = 0;
        int ans = 0;
        while(i < A.length - 1) {
            if(A[i+1] > A[i]) {
                int upHill = 0;
                while(i < A.length - 1 && A[i+1] > A[i]) {
                    i++;
                    upHill++;
                }
                int downHill = 0;
                while(i < A.length - 1 && A[i] > A[i+1]) {
                    i++;
                    downHill++;
                }
                ans = upHill != 0 && downHill !=0 ? Math.max(upHill + downHill +1 , ans) : ans;
            }
            else {
                i++;
            }
        }
        return ans;
    }
}
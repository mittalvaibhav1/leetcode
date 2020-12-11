//https://leetcode.com/problems/sort-array-by-parity-ii
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int even = 0;
        int odd = 1;
        for(int i = 0 ; i < A.length ; i++) {
            if(A[i] % 2 == 0) {
                res[even] = A[i];
                even += 2;
            }
            else {
                res[odd] = A[i];
                odd += 2;
            }
        }
        return res;
    }
}
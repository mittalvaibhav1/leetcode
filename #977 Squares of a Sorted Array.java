//https://leetcode.com/problems/squares-of-a-sorted-array/
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int i = -1;
        for(int n : A) {
            if(n >= 0) break;
            i++;
        }
        int j = i + 1;
        int k = 0;
        while(i >= 0 && j < A.length) {
            if(A[i] * A[i] < A[j] * A[j]) {
                res[k++] = A[i] * A[i];
                i--;
            }
            else  {
               res[k++] = A[j] * A[j];
               j++;  
            }
        }
        while(i >= 0) {
             res[k++] = A[i] * A[i];
             i--;
        }
        while(j < A.length) {
            res[k++] = A[j] * A[j];
            j++; 
        }
        return res;
    }
}
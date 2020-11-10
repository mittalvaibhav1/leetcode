//https://leetcode.com/problems/flipping-an-image/
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0 ; i < A.length ; i++) {
            invertReverse(A[i]);
        }
        return A;
    }
    public void invertReverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int tmp = (arr[left] == 0) ? 1 : 0;
            arr[left] = (arr[right] == 0) ? 1 : 0;
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
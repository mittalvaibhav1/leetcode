//https://leetcode.com/problems/squares-of-a-sorted-array/
//M 1 O(nlogn)
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int k = 0;
        for(int i : A) {
            res[k++] = i * i;
        }
        Arrays.sort(res);
        return res;
    }
}
//https://leetcode.com/problems/shuffle-the-array
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int j = 0 , k = n;
        for(int i = 0 ; i < 2 * n ; i++) {
            if(i % 2 == 0) {
                res[i] = nums[j++];
            }
            else {
                res[i] = nums[k++];
            }
        }
        return res;
    }
}
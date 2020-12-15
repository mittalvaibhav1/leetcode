//https://leetcode.com/problems/squares-of-a-sorted-array/
//M1
class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = -1 , j = 0 , k = 0;
        int[] res = new int[nums.length];
        for(int itr = 0 ; itr < nums.length ; itr++,i++) {
            if(nums[itr] >= 0) {
                break;
            }
        }
        j = i + 1;
        while(j < nums.length && i >= 0) {
            if(nums[i] * nums[i] < nums[j] * nums[j]) {
                res[k++] = nums[i] * nums[i];
                i--;
            } 
            else {
                res[k++] = nums[j] * nums[j];
                j++;
            }
        }
        while(j < nums.length) {
            res[k++] = nums[j] * nums[j];
            j++;
        }
        while(i >= 0) {
            res[k++] = nums[i] * nums[i];
            i--;
        }
        return res;
    }
}
// M2
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
//https://leetcode.com/problems/product-of-array-except-self/
// M1 3ms
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        left[0] = 1;
        int right[] = new int[nums.length];
        right[nums.length - 1] = 1;
        for(int i = 1 ; i < nums.length ; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        for(int i = nums.length - 2 ; i >= 0 ; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        for(int i = 0 ; i < nums.length ; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}
// M2 1ms
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int answer[] = new int[nums.length]; answer[0] = 1;
        int right = 1;
        for(int i = 1 ; i < nums.length ; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }
        for(int i = nums.length - 1 ; i >= 0 ; i--) {
            answer[i] = answer[i] * right;
            right = right * nums[i];   
        }
        return answer;
    }
}
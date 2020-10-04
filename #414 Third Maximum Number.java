//https://leetcode.com/problems/third-maximum-number/
class Solution {
    public int thirdMax(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        for(int i : nums) {
            max1 = Math.max(i,max1);
        }
        boolean max3assigned = false;
        boolean max2assigned = false;
        int max2 = Integer.MIN_VALUE; 
        for(int i : nums) {
            if(i!=max1){
                max2=Math.max(max2,i);
                max2assigned = true;
            }
        }
        if(max1==max2 || !max2assigned){
            return max1;
        }
        int max3 = Integer.MIN_VALUE; 
        for(int i : nums) {
            if(i!=max2 && i!=max1){
                max3=Math.max(max3,i);
                max3assigned = true;
            }
        }
        if(max2==max3 || !max3assigned){
            return max1;
        }
        return max3;
        
    }
}
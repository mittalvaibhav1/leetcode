//https://leetcode.com/problems/k-diff-pairs-in-an-array/
class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer,Boolean> set = new HashMap<>();
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(set.containsKey(nums[i])){
                if(k==0 && !set.get(nums[i])){
                    count++;
                    set.put(nums[i],true);
                }
               continue; 
            } 
            set.put(nums[i],false);
            if(k!=0 && ( set.containsKey(nums[i]-k) || set.containsKey(nums[i]+k) ) ) {
                if(set.containsKey(nums[i]-k) && set.containsKey(nums[i]+k) ) {
                    count++;
                }
                count++;      
            }
        }
        return count;
    }
}
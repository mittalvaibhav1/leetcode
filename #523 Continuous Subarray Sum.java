//https://leetcode.com/problems/continuous-subarray-sum/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum  = 0;
        for(int i = 0; i < nums.length ; i++) {
            sum += nums[i];
            if(k!=0) sum = sum % k;
            if(map.containsKey(sum)) {
                int size = i - map.get(sum);
                if(size > 1) return true;
            }
            if(!map.containsKey(sum)) map.put(sum , i);
        }
        return false;
    }
}
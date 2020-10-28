//https://leetcode.com/problems/132-pattern/
// Method 1 O(nlong)
// class Solution {
//     public boolean find132pattern(int[] nums) {
//         TreeMap<Integer,Integer> map1 = new TreeMap<Integer,Integer>();
//         for(int i = 1 ; i < nums.length ; i++) {
//             map1.put(nums[i],map1.getOrDefault(nums[i],0) + 1);
//         }
//         int minLeft = nums[0];
//         for(int i = 1 ; i < nums.length ; i++) {
//             int val = map1.get(nums[i])-1;
//             if(val == 0) map1.remove(nums[i]);
//             else map1.put(nums[i],val);
//             if(nums[i] > minLeft && map1.subMap(minLeft+1,nums[i]).size()!=0) return true;
//             minLeft = Math.min(minLeft,nums[i]);
//         }
//         return false;
//     }
// }
// Method 2 O(N)
public class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
            min[i] = Math.min(nums[i], min[i-1]);
        }
        Stack<Integer> st = new Stack<>();
        for(int i = nums.length - 1 ; i >=0 ; i--) {
            if(nums[i] > min[i]) {
                while(!st.isEmpty() && st.peek() <= min[i] ) {
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()  < nums[i]) {
                    return true;
                }
                st.push(nums[i]);
            }
        }
        return false;
    }
}
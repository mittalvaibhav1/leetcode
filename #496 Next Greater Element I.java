//https://leetcode.com/problems/next-greater-element-i
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>(nums2.length);
        for(int i = 0 ; i < nums2.length ; i++) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for(int i = 0 ; i < nums1.length ; i++) {
            nums1[i] = map.containsKey(nums1[i])? map.get(nums1[i]) : -1;
        }
        return nums1;
    }
}
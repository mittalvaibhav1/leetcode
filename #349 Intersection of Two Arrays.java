//https://leetcode.com/problems/intersection-of-two-arrays
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int num : nums1) 
            set1.add(num);
        for(int num : nums2) 
            if(set1.contains(num)) 
                set2.add(num);
        int[] res = new int[set2.size()];
        int k = 0;
        for(int i : set2) {
            res[k++] = i;
        }
        return res;
    }
}
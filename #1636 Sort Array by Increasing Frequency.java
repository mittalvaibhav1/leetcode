//https://leetcode.com/problems/sort-array-by-increasing-frequency/
class Solution {
    public int[] frequencySort(int[] nums) {
        int[][] count = new int[201][2];
        for(int i = 0 ; i < nums.length ; i++) {
            count[nums[i] + 100][0] = nums[i];
            count[nums[i] + 100][1]++;
        }
        Arrays.sort(count,(a,b)-> a[1] == b[1] ? Integer.compare(b[0],a[0]):Integer.compare(a[1],b[1]));
        int k  = 0;
        for(int i = 0 ; i < count.length ; i++) {
            while(count[i][1]-- > 0) {
                nums[k++] = count[i][0];
            }
        }
        return nums;
    }
}
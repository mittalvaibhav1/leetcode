//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) {
            return 0;
        }  
        Arrays.sort(points , (a,b) -> Integer.compare(a[1],b[1]) );
        int ans = 1;
        int prev = points[0][1];
        for(int[] point : points) {
            if(point[0] > prev) {
                ans++;
                prev = point[1];
            }
        }
        return ans;
    }
}
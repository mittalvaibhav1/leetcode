//https://leetcode.com/problems/non-overlapping-intervals/
class Solution {
    public int eraseOverlapIntervals(int[][] points) {
       if(points.length == 0) {
            return 0;
        }  
        Arrays.sort(points , (a,b) -> a[1] - b[1]);
        int remove = -1;
        int[] prev = points[0];
        
        for(int[] point : points) {
           // System.out.println(point[0] + " " + point[1]);
            if(point[0] < prev[1] ) {
                remove++;
            }
            else {
                prev = point;
            }
        }
        return remove;
    }
}
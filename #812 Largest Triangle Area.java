//https://leetcode.com/problems/largest-triangle-area/
class Solution {
    public double largestTriangleArea(int[][] points) {
       double area = 0;
       for(int i = 0 ; i < points.length - 2 ; i++) {
           for(int j = i+1 ; j < points.length - 1 ; j++) {
               for(int k = j+1 ; k < points.length ; k++ ) {
                   area = Math.max(area,calArea(points[i],points[j],points[k]));
               }
           }
       } 
       return area; 
    }
    public double distance(int[] a , int[] b) {
        return Math.sqrt((b[0]-a[0])*(b[0]-a[0]) + (b[1]-a[1])*(b[1]-a[1]));
    }
    public double calArea(int[] x , int[] y , int[] z) {
        double a = distance(x,y);
        double b = distance(x,z);
        double c = distance(y,z);
        double s = (a+b+c) / 2.0d;
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        if(area > 0) {
            return area;
        }
        return 0;
    }
}
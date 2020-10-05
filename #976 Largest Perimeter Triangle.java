//https://leetcode.com/problems/largest-perimeter-triangle/
class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int i = A.length - 1 ; i - 2 >= 0 ; i--){
                int peri = A[i] + A[i-1] + A[i-2];
                if(nonZeroArea(A[i], A[i-1] , A[i-2]))
                    return peri;
        }
        return 0;
    }
    public boolean nonZeroArea(int a , int b , int c) {
        double s = (a+b+c) / 2.0d;
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        if(area == 0 || Double.isNaN(area)) {
            return false;
        }
        return true;
    }
}
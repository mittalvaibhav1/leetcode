//https://leetcode.com/problems/champagne-tower/
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] arr = new double[1 + query_row][1 + query_row];
        arr[0][0] = (double)poured;
        for(int i = 0 ; i <query_row ; i++) {
            for(int j = 0 ; j <=i ; j++) {
                double down = (arr[i][j] - 1.0)/2.0;
                if(down > 0) {
                 arr[i+1][j] += down;
                 arr[i+1][j+1] += down;   
                }
            }
        }
        return Math.min(1d,arr[query_row][query_glass]);
    }
}
// /https://leetcode.com/problems/spiral-matrix-ii/
class Solution {
    public int[][] generateMatrix(int dim) {
        int[][] res = new int[dim][dim];
        int val = 1;
        int m = dim , n = dim;
        int x = 0 , y = 0;
        while(x < m && y < n) {
            for(int i = y ; i < n ; i++) {
                res[x][i] = val++;
            }
            x++;
            for(int i = x ; i < m ; i++) {
                res[i][n - 1] = val++;
            }
            n--;
            if(x < m) {
                for(int i = n - 1 ; i >= y ; i--) {
                    res[m - 1][i] = val++;
                }
                m--;
            }
            if(y < n) {
                for(int i = m -1 ; i >= x ; i--) {
                    res[i][y] = val++;
                }
                y++;
            }
        }
        return res;
    }
}
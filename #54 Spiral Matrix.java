//https://leetcode.com/problems/spiral-matrix/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);
        int x  = 0;
        int y = 0;
        while(x < m && y < n) {
            for(int i = y ; i < n ; i++) {
                res.add(matrix[x][i]);
            }
            x++;
            for(int i = x ; i < m ; i++) {
                res.add(matrix[i][n-1]);
            }
            n--;
            if(x < m) {
                for(int i = n - 1 ; i >= y ; i--) {
                    res.add(matrix[m-1][i]);
                }
                m--;
            }
            if(y < n) {
                for(int i = m - 1 ; i >=x ; i--) {
                    res.add(matrix[i][y]);
                }
                y++;
            }
        }
        return res;
    }
}
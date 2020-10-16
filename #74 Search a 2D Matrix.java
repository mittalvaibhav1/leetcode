//https://leetcode.com/problems/search-a-2d-matrix/
class Solution {
    ArrayList<Integer> cols;
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length ==0) return false;
        cols = new ArrayList<>();
        for(int i = 0 ; i < matrix.length ; i++) {
            cols.add(matrix[i][0]);
        }
        int i = rowSearch(target);
        if(i == -1) return false;
        int j = columnSearch(matrix,target,i);
        if(j == - 1) return false;
        return true;
    }
    public int columnSearch(int[][] matrix , int target , int row) {
        int start = 0 ;
        int end = matrix[0].length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(matrix[row][mid] == target) {
                return mid;
            }
            else if(matrix[row][mid] < target) {
                start = mid +1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
    public int rowSearch(int target) {
        int start = 0 ;
        int end = cols.size() - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(cols.get(mid) == target) {
                return mid;
            }
            else if(cols.get(mid) < target) {
                start = mid +1;
            }
            else {
                end = mid - 1;
            }
        }
        return end;
    }
}
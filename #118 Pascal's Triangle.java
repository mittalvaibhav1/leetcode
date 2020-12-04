//https://leetcode.com/problems/pascals-triangle/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        if(numRows == 0) return res;
        ArrayList<Integer> row = new ArrayList<>(numRows);
        row.add(1);
        res.add(new ArrayList(row));
        row.clear();
        for(int i  = 1 ; i < numRows ; i++) {
            for(int j = 0 ; j <= i; j++) {
                int left = j - 1;
                int right = j;
                if(left < 0 || right >= res.get(i-1).size()) 
                    row.add(1);
                else {
                    row.add(res.get(i-1).get(left) + res.get(i-1).get(right));
                }
            }
            res.add(new ArrayList(row));
            row.clear();
        }
        return res;
    }
}
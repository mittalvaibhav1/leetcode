//https://leetcode.com/problems/pascals-triangle-ii/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex);
        List<Integer> prev = null;
        for(int i = 0 ; i <= rowIndex ; i++) {
            for(int j = 0 ; j <= i ; j++) {
                int left = j - 1;
                int right = j;
                if(prev == null || left < 0 || right >= prev.size()) 
                    res.add(1);
                else
                    res.add(prev.get(left) + prev.get(right));
            }
            prev = new ArrayList(res);
            res.clear();
        }
        return prev;
    }
}
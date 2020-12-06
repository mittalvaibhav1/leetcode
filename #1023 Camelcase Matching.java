//https://leetcode.com/problems/camelcase-matching/
class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>(queries.length);
        int len = pattern.length();
        for(String query : queries) {
            int i = 0,k = 0;
            int qlen = query.length();
            while(i < qlen) {
                if(k < len && query.charAt(i) == pattern.charAt(k)) {
                    k++; i++;
                }
                else if(!Character.isLowerCase(query.charAt(i))) {
                    break;
                }
                else {
                    i++;
                }
            }
            if(i == qlen && k == len) res.add(true);
            else res.add(false);
        }
        return res;
    }
}
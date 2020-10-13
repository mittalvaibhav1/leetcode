//https://leetcode.com/problems/longest-common-prefix/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        StringBuilder res = new StringBuilder();
        boolean flag = true;
        int min = Integer.MAX_VALUE;
        for(String s : strs) {
            min = Math.min(s.length(),min);
        }
        for(int i = 0 ; i < min ; i++) {
            flag = true;
            for(int j = 0 ; j < strs.length - 1 ; j++) {
                if(strs[j].charAt(i) != strs[j+1].charAt(i)){
                    return res.toString();
                }
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }
}
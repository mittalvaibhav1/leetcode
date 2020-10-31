//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
class Solution {
    public int minAddToMakeValid(String S) { 
        while(S.contains("()"))
        S = S.replaceAll("\\(\\)","");
        return S.length();
    }
}
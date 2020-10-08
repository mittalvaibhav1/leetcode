//https://leetcode.com/problems/is-subsequence/
class Solution {
    public boolean isSubsequence(String s, String t) {
       if(s.length() > t.length()) {
           return false;
       }
       if(s.length() == 0 ) {
           return true;
       }
       int index = 0; 
       for(char i : t.toCharArray()) {
           if(i == s.charAt(index)){
               index++;
                if(index == s.length()) {
                   return true;
               }
           }
       } 
       return false; 
    }
} 
//https://leetcode.com/problems/repeated-substring-pattern/
//M1 34ms
class Solution {
    public boolean repeatedSubstringPattern(String s) {
       for(int i = 1 ; i <= s.length()/2 ; i++) {
           if(s.length() % i != 0) continue;
           String rep = s.substring(0,i);
           StringBuilder sb = new StringBuilder();
           while(sb.length() < s.length()) {
               sb.append(rep);
           }
           if(sb.toString().equals(s)) return true;
       }
       return false; 
    }
}
// M2 - 15ms
class Solution {
    public boolean repeatedSubstringPattern(String s) {
       int len = s.length();
       for(int i = len/2 ; i >=1 ; i--) {
           if(len % i != 0) continue;
           String rep = s.substring(0,i);
           StringBuilder sb = new StringBuilder();
           int k = len / i;
           int j = 0;
           while(j++ < k) {
               sb.append(rep);
           }
           if(sb.toString().equals(s)) return true;
       }
       return false; 
    }
}
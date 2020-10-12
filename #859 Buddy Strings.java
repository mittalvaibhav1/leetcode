//https://leetcode.com/problems/buddy-strings/
class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        int prev = -1;
        int change = 0;
        int repeat = 0;
        int fix = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < A.length() ; i++) {
            if(A.charAt(i)!=B.charAt(i)) {
                change++;
                if(change>2) return false;
                if(prev == -1) {
                    prev = i;
                }
                else {
                  if(A.charAt(prev) == B.charAt(i) && B.charAt(prev) == A.charAt(i)) {
                      fix++;
                  }
                  else {
                      return false;
                  }  
                }
            }
            else {
                if(!set.contains(A.charAt(i))) {
                    set.add(A.charAt(i));
                }else {
                    repeat = 1;
                }
            }
        }
        if(fix == 1 || change == 0 && repeat == 1 )
            return true;
        else
            return false;
    }
}
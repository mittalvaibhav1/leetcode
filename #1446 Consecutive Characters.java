//https://leetcode.com/problems/consecutive-characters/
class Solution {
    public int maxPower(String s) {
        char curr = s.charAt(0);
        int runningLength = 1;
        int maxLength = 1;
        for(int i = 1 ; i < s.length() ; i++) {
            if(s.charAt(i) == curr) {
                runningLength++;
            }
            else  {
                maxLength = Math.max(runningLength,maxLength);
                runningLength = 1;
                curr = s.charAt(i);
            }
        }
        maxLength = Math.max(runningLength,maxLength);
        return maxLength;
    }
}
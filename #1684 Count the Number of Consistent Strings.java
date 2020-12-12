//https://leetcode.com/problems/count-the-number-of-consistent-strings/
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] allowedMap = new int[26];
        int count = 0;
        for(char i : allowed.toCharArray()) {
            allowedMap[i - 'a']++;
        }
        for(String s : words) {
            if(isConsistent(allowedMap,s)) count++;
        }
        return count;
    }
    public boolean isConsistent(int[] map , String s) {
        for(char i : s.toCharArray()) {
            if(map[i-'a'] == 0) return false;
        }
        return true;
    }
}
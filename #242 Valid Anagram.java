//https://leetcode.com/problems/valid-anagram/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int size = s.length();
        int index[] = new int[26];
        for(int i = 0 ; i < size ; i++) {
            index[s.charAt(i) - 'a']++;
            index[t.charAt(i) - 'a']--;
        }
        for(int i : index) {
            if(i != 0) return false;
        }
        return true;
    }
}
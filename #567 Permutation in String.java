//https://leetcode.com/problems/permutation-in-string/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int reqlen = s1.length();
        int totallen = s2.length();
        
        if(totallen < reqlen) return false;
        
        int[] count = new int[26];
        for(char i : s1.toCharArray()) count[i - 'a']++;
        
        int[] cache = new int[26];
        int windowStart = 0;
        
        for(int i = 0 ; i < totallen ; i++) {
            char curr = s2.charAt(i);
            if(count[curr - 'a'] == 0) {
                windowStart = i + 1;
                resetCache(cache);
                if(totallen - windowStart < reqlen) return false;
                continue;
            }
            else {
                cache[curr - 'a']++;
            }
            while(cache[curr - 'a'] > count[curr - 'a'] && windowStart <= i) {
                cache[s2.charAt(windowStart++) - 'a']--;
            }
            if(i - windowStart + 1 == reqlen) {
                return true;
            }
            
        }
        return false;   
    }
    public void resetCache(int[] cache) {
        for(int i = 0 ; i < 26 ; i++) {
            cache[i] = 0;    
        }
    }
}
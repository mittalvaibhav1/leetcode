//https://leetcode.com/problems/find-all-anagrams-in-a-string/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        int totalLen = s.length();
        int reqLen = p.length();
        if(totalLen < reqLen) return res;
        
        int[] count = new int[26];
        for(char i : p.toCharArray()) {
            count[i - 'a']++;
        }
        
        int windowStart = 0;
        int[] cache = new int[26];
        for(int i = 0 ; i < totalLen ; i++) {
            char curr = s.charAt(i);
            if(count[curr - 'a'] == 0) {
                windowStart = i + 1;
                resetCache(cache);
                if(totalLen - windowStart < reqLen) return res;
                continue;
            }
            else {
                cache[curr - 'a']++;
            }
            while(cache[curr - 'a'] > count[curr - 'a'] && windowStart <= i) {
                cache[s.charAt(windowStart++) - 'a']--;
            }
            if(i - windowStart + 1 == reqLen) {
                res.add(windowStart);
            }
        }
        return res;
    }
    public void resetCache(int[] cache) {
        for(int i = 0 ; i < 26 ; i++) {
            cache[i] = 0;
        }
    }
}
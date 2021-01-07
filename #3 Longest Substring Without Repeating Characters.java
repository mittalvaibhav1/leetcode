//https://leetcode.com/problems/longest-substring-without-repeating-characters
//M1 - O(n) - 7ms
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0,i = 0,j = 0;
        char tmp;
        while(i<size && j<size)
        {
            tmp = s.charAt(j);
            if(!map.containsKey(tmp))
            {
                map.put(tmp,j);
                j++;
                max=Math.max(max,j-i);
            }        
            else
            {
                i = Math.max(map.get(tmp)+1,i);
                map.remove(tmp);
            }
        }
        
        return max;
    }
}

//M2 O(n) - 4ms
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] cache = new boolean[256];
        int ans = 0 , len = s.length() , start = 0;
        for(int i = 0 ; i < len ; i++) {
            char curr = s.charAt(i);
            while(cache[curr]) {
                cache[s.charAt(start++)] = false;
            }
            cache[curr] = true;
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
//M3 O(n) - 2ms
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] cache = new boolean[256];
        char[] S = s.toCharArray();
        int ans = 0 , len = S.length , start = 0;
        for(int i = 0 ; i < len ; i++) {
            char curr = S[i];
            while(cache[curr]) {
                cache[S[start++]] = false;
            }
            cache[curr] = true;
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
//https://leetcode.com/problems/remove-duplicate-letters/
class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder res = new StringBuilder();
        int[] index = new int[26];
        boolean[] added = new boolean[26];
        for(char i : s.toCharArray())
            index[i-'a']++;
        for(char i : s.toCharArray()) {
            index[i-'a']--;
            if(!added[i-'a']) {
                added[i-'a'] = true;
                if(res.length() == 0) 
                    res.append(i);
                else {
                    while(res.length()!=0 && res.charAt(res.length()-1) > i  && index[res.charAt(res.length() -1)-'a'] > 0) {
                        added[res.charAt(res.length() -1) -'a'] = false;
                        res.deleteCharAt(res.length() - 1);
                    }
                    res.append(i);
                }
                
            }
        }
        return res.toString();
    }
}
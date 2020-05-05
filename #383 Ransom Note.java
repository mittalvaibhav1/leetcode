//https://leetcode.com/problems/ransom-note/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int index[] = new int[26];
        
        for(int i = 0 ; i < magazine.length() ; i++)
        {
            index[magazine.charAt(i) - 'a']++;
        }
        
        for(int i = 0 ; i < ransomNote.length() ; i++)
        {
            index[ransomNote.charAt(i) - 'a']--;
        }
        
        for(int i = 0 ; i < 26 ; i++)
        {
            if(index[i]<0)
                return false;
        }
        return true;
        
    }
}
//https://leetcode.com/problems/valid-anagram/submissions/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i<s.length();i++)
        {
            char tmp = s.charAt(i);
            if(map.containsKey(tmp))
            {
                map.put(tmp,map.get(tmp)+1);
            }
            else
            {
                map.put(tmp,1);
            }
        }
        for(int i = 0 ; i<t.length();i++)
        {
            char tmp = t.charAt(i);
            if(map.containsKey(tmp))
            {
                map.put(tmp,map.get(tmp)-1);
                if(map.get(tmp)<0)
                    return false;
            }
            else
            {
                return false;
            }
        }
        for(int i = 0 ; i<s.length();i++)
        {
            char tmp = s.charAt(i);
            if(map.get(tmp)!=0)
                return false;
        }
        return true;
    }
}
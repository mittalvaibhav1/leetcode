//https://leetcode.com/problems/jewels-and-stones/
class Solution {
    public int numJewelsInStones(String J, String S) {
        
        HashSet<Character> hs = new HashSet<>();
        int count = 0;
        for(int i = 0 ; i< J.length() ; i++)
        {
            hs.add(J.charAt(i));
        }
        for(int i = 0 ; i< S.length() ; i++)
        {
            if(hs.contains(S.charAt(i)))
                count++;
        }
            
        return count;
    }
}
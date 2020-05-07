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
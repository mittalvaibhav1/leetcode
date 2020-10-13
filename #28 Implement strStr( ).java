//https://leetcode.com/problems/implement-strstr/
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        if(needle.length() > haystack.length()) return -1;
        char[] needleA = needle.toCharArray();
        char[] haystackA = haystack.toCharArray();
        int j = 0;
        int index =-1;
        for(int i = 0 ; i < haystackA.length ; i++) {
            if(needleA[j] == haystackA[i]) {
                j++;
                if(index == -1) index = i;
                if(j == needleA.length) {
                    return index;
                }
            }
            else {
                i = index != -1 ? index : i; 
                index = -1;
                j = 0;
            }
        }
        return -1;
    }
}

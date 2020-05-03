//https://leetcode.com/problems/reverse-string/
class Solution {
    public void reverseString(char[] s) 
    {
    	char c;
        for(int i=0;i<s.length/2;i++)// Solution in O(n) time and O(1) space complexity.
        {
            c = s[i];
            s[i]=s[s.length-1-i];
            s[s.length-1-i]=c;// Simply swapping the characters from 1st and the 2nd half of the array.
        }
    }
}
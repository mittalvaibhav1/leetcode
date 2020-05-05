//https://leetcode.com/problems/number-complement/
class Solution {
    public int findComplement(int num) {
        
        char arr[] = Integer.toBinaryString(num).toCharArray();
        
        for(int i = 0 ; i<arr.length; i++)
        {
            if(arr[i]=='0')
                arr[i]='1';
            else
                arr[i]='0';
        }
        int i = Integer.parseInt(String.valueOf(arr),2);
        return i;
    }
}
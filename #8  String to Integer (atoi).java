//https://leetcode.com/problems/string-to-integer-atoi/
class Solution {
    public int myAtoi(String str) {
        
        str = str.trim();
        
        boolean plus = false;
        boolean minus = false;
        boolean digit = false;
        String expr = "";
        
        for(char c : str.toCharArray())
        {
            if(c=='+' && digit==false && plus==false)
            {
                plus=true;
            }
            else if(c == '-' && digit==false && minus==false)
            { 
                minus=true; 
            }
            else if(Character.isDigit(c))
            {
                expr+=String.valueOf(c);
                digit=true;
            }
            else
            {
                if(digit==false)
                    return 0;
                else
                    break;
            }
        }
        if(plus && minus)
            return 0;
        if(expr=="")
            return 0;
        long sum = 0;
        try{
        sum = Long.parseLong(expr);
        }
        catch(Exception ex)
        {
            if(minus)return Integer.MIN_VALUE;
             return Integer.MAX_VALUE;
        }
        if(minus)
            sum*=-1;
        if(sum>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(sum<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)sum;
    }
}
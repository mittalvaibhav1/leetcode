//https://leetcode.com/problems/add-binary/
class Solution {
    public String addBinary(String a, String b) {
        
        int m = a.length()-1 , n = b.length()-1;
        StringBuilder output = new StringBuilder();
        int carry = 0,ai=0,bi=0;    
        while(m >= 0 || n >= 0)
        {
            ai = 0;
            bi = 0;
            if(m>=0)ai = a.charAt(m--)-'0';
            if(n>=0)bi = b.charAt(n--)-'0';
            
            int tmp = ai + bi + carry;
            carry = tmp > 1 ? 1 : 0;
            output.append(tmp&1); 
            
        }
        if(carry>0)
        {
            output.append(carry);
        }
        return output.reverse().toString();
    }
}
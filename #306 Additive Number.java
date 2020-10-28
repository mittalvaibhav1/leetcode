//https://leetcode.com/problems/additive-number/
class Solution {
    public boolean isAdditiveNumber(String num) {
        return helper(num,-1,-1,0,false);
    }
    public boolean helper(String num , long first , long second, int index , boolean third) {
        if(third== true && index == num.length()) return true;
        
        for(int i = index + 1 ; i <= num.length() ; i++) {
            long curr;
            try {
                curr = Long.parseLong(num.substring(index,i));
            }
            catch(Exception ex) {
                return false;
            }
            if(first == -1) {
                if(helper(num,curr,-1,i,false))
                    return true;
            }
            else if(second == -1) {
                if(helper(num,first,curr,i,false))
                    return true;
            }
            else if(first + second == curr) {
                if(helper(num,second,curr,i,true)) 
                    return true;
            }
            else if(first + second < curr) {
                return false;
            }
            if(curr == 0) return false; 
        }
        return false;
    }
}
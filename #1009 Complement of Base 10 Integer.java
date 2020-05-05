//https://leetcode.com/problems/complement-of-base-10-integer/
class Solution {
    public int bitwiseComplement(int num) { 
        int sum = 1;
        while(sum<num)
            sum = (sum<<1) + 1;
        return sum - num;
    }
}
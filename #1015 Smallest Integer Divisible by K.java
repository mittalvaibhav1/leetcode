//https://leetcode.com/problems/smallest-integer-divisible-by-k/
class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0) return -1;
        int len = 1;
        int n = 1;
        while(n % k != 0) {
            if(len > k) return -1;
            len++;
            n = ((n * 10) + 1)%k;
            
        }
        return len;
    }
}
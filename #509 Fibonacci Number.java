//https://leetcode.com/problems/fibonacci-number/
class Solution {
    public int fib(int N) {
        int i = -1;
        int j = 1; 
        int sum = 0;
        while(N-- >= 0) {
            sum = i + j;
            i = j;
            j = sum;
        }
        return sum;
    }
}
//https://leetcode.com/problems/mirror-reflection/
class Solution {
    public int mirrorReflection(int p, int q) {
        int x = 0;
        int y = 0;
        while(true) {
            y += q;
            x = x == 0 ? p : 0;
            if(y % p == 0) {
                if(x == 0) return 2;
                else if(y / p % 2 == 0) return 0;
                else return 1;
            }
        }
    }
}
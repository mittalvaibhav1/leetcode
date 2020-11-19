//https://leetcode.com/problems/poor-pigs/submissions/
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int tests = minutesToTest / minutesToDie + 1;
        int pigs = 0;
        while(Math.pow(tests,pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}
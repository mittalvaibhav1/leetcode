//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        //Find Subarray of given length with Minimum Sum;
        int totalSum = 0;
        for(int cardPoint : cardPoints) totalSum += cardPoint;
        int subarrayLength = cardPoints.length - k;
        if(subarrayLength == 0) return totalSum;
        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;
        int windowStart = 0;
        for(int i = 0 ; i < cardPoints.length ; i++) {
            currentSum += cardPoints[i];
            int windowLength = (i - windowStart) + 1;
            while(windowLength > subarrayLength) {
                currentSum -= cardPoints[windowStart++];
                windowLength = (i - windowStart) + 1;
            }
            if(windowLength == subarrayLength) {
                minSum = Math.min(minSum , currentSum);
            }
        }
        return totalSum - minSum;
    }
}
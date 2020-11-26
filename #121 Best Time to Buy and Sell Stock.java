//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] max = new int[len];
        int res = 0;
        for(int i = len - 2 ; i >= 0 ; i--) {
            max[i] = Math.max(prices[i+1],max[i+1]);
        }
        for(int i = 0 ; i < len - 1;i++) {
            res = Math.max(res,max[i] - prices[i]);
        }
        return res;
    }
}
//https://leetcode.com/problems/bag-of-tokens/
class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int score = 0;
        int ans = 0;
        int left = 0;
        int right = tokens.length - 1;
        while(left <= right) {
            if(P >= tokens[left]) {
                P-= tokens[left];
                left++;
                score++;
            }
            else if(score >= 1) {
                score--;
                P += tokens[right];
                right--;
            }
            else {
                break;
            }
            ans = Math.max(score,ans);
        }
        return ans;
    }
}
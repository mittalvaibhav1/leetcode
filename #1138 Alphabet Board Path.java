//https://leetcode.com/problems/alphabet-board-path/
class Solution {
    public String alphabetBoardPath(String t) {
        StringBuilder ans = new StringBuilder();
        int curr = 0;
        for(char i : t.toCharArray()) {
            int target = (int)(i - 'a');
            int targetVertical = target/5;
            int targetHorizontal = target%5;
            int currVertical = curr/5;
            int currHorizontal = curr%5;
            while(currVertical < targetVertical && currVertical < 4) {
                currVertical++;
                ans.append("D");
            }
            while(currVertical > targetVertical) {
                currVertical--;
                ans.append("U");
            }
            while(currHorizontal < targetHorizontal) {
                currHorizontal++;
                ans.append("R");
            }
            while(currHorizontal > targetHorizontal) {
                currHorizontal--;
                ans.append("L");
            }
            if(currVertical < targetVertical) {
                currVertical++;
                ans.append("D");
            }
            curr = target;
            ans.append("!");
        }
        return ans.toString();
    }
    
}
//https://leetcode.com/problems/rearrange-words-in-a-sentence/
class Solution {
    public String arrangeWords(String text) {
        String[] tokens = text.split(" ");
        tokens[0] = tokens[0].toLowerCase();
        Arrays.sort(tokens , (a,b) -> Integer.compare(a.length(),b.length()));
        StringBuilder sb = new StringBuilder();
        sb.append(tokens[0].substring(0,1).toUpperCase()).append(tokens[0].substring(1));
        for(int i = 1 ; i < tokens.length ; i++) {
            sb.append(" ").append(tokens[i]);
        }
        return sb.toString();
    }
}
//https://leetcode.com/problems/reverse-words-in-a-string-iii/
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(String word : words) {
            ans.append(new StringBuilder(word).reverse()).append(" ");
        }
        return ans.toString().trim();
    }
}
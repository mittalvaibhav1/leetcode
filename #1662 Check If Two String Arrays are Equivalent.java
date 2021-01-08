//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder w1 = new StringBuilder();
        StringBuilder w2 = new StringBuilder();
        for(String word : word1) {
            w1.append(word);
        }
        for(String word : word2) {
            w2.append(word);
        }
        return w1.toString().equals(w2.toString());
    }
}
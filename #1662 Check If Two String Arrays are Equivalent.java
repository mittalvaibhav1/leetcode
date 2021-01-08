//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
// M1 - O(n)
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
// M2 - O(n)
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1 = 0 , w2 = 0, c1 = 0 , c2 = 0;
        while(w1 < word1.length && w2 < word2.length) {
            if(word1[w1].charAt(c1) != word2[w2].charAt(c2)) return false;
            c1++;
            c2++;
            if(c1 % word1[w1].length() == 0) {
                w1++;
                c1 = 0;
            }
            if(c2 % word2[w2].length() == 0) {
                w2++;
                c2 = 0;
            }
        }
        return c1 == 0 && c2 == 0 && w1 == word1.length && w2 == word2.length;
    }
}
//https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
class Solution {
    public int minSteps(String s, String t) {
        int[] index = new int[26];
        for(char i : s.toCharArray()) {
            index[i-'a']++;
        }
        for(char i : t.toCharArray()) {
            index[i-'a']--;
        }
        int sum = 0;
        for(int i : index) {
            sum += Math.abs(i);
        }
        return sum/2;
    }
}
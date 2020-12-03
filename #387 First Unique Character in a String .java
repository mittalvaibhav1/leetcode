//https://leetcode.com/problems/first-unique-character-in-a-string/
class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length ; i++) {
            count[arr[i] -'a']++;
        }
        for(int i = 0; i < arr.length ; i++) {
            if(count[arr[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}
//https://leetcode.com/problems/first-unique-character-in-a-string/
class Solution {
    public int firstUniqChar(String s) {
        int[] index = new int[26];
        char[] arr = s.toCharArray();
        for(char i : arr) {
            index[i-'a']++;
        }
        for(int i = 0 ; i < arr.length ; i++) {
            if(index[arr[i]-'a'] == 1)
                return i;
        }
        return -1;
    }
}
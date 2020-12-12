//https://leetcode.com/problems/count-the-number-of-consistent-strings/
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] allowedMap = new int[26];
        int count = 0;
        for(char i : allowed.toCharArray()) {
            allowedMap[i - 'a']++;
        }
        for(String s : words) {
            if(isConsistent(allowedMap,s)) count++;
        }
        return count;
    }
    public boolean isConsistent(int[] map , String s) {
        for(char i : s.toCharArray()) {
            if(map[i-'a'] == 0) return false;
        }
        return true;
    }
}
//with comments
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] allowedMap = new int[26]; // create an array 
		//for all the lowercase 26 english alphabets
		// 0 index -> a , 1 index -> b , 2 index -> c . . . . . . . 25 index -> z;
        int count = 0; // Count of consistent strings
        for(char i : allowed.toCharArray()) {
            allowedMap[i - 'a']++; // increase the value at the index corresponding to 
			// the character for all the characters present in allowed string
			//if char is c then (c - a) would give 2 which is the index for c
        }
        for(String s : words) {
            if(isConsistent(allowedMap,s)) count++; // for each word check 
			//if it consitent or not and increase the count on getting true;
        }
        return count;
    }
    public boolean isConsistent(int[] map , String s) {
        for(char i : s.toCharArray()) {
            if(map[i-'a'] == 0) return false; // iterate thorugh all the characters
			// and check if it is present in the allowedMap or not.
			// if count in map is zero. that means it is not present in the allowed string so return false.
        }
        return true; // if all the chars were present in the string.
    }
}
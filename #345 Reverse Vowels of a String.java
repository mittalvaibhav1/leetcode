//https://leetcode.com/problems/reverse-vowels-of-a-string/
class Solution {
    public String reverseVowels(String s) {
        char[] res = s.toCharArray();
        int left = 0;
        int right = res.length - 1;
        while(left < right) {
            boolean isLeft = isVowel(res[left]);
            boolean isRight = isVowel(res[right]);
            if(isLeft && isRight) {
                char tmp = res[left];
                res[left] = res[right];
                res[right] = tmp;
                left++;
                right--;
            }
            else if(isLeft) {
                right--;
            }
            else if(isRight) {
                left++;
            }
            else {
                left++;
                right--;
            }
        }
        return new String(res);
    }
    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c =='a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'; 
    }
}
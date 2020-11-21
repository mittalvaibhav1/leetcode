
//https://leetcode.com/problems/custom-sort-string/
//M1
class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        Character [] arr = new Character[T.length()];
        for(int i = 0; i < T.length() ; i++) {
            arr[i] = T.charAt(i);
        }
        for(int i = 0 ; i < S.length() ; i++) {
            map.put(S.charAt(i),i);
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(map.getOrDefault(a,-1),map.getOrDefault(b,-1)));
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i< arr.length ; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
// M2
class Solution {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for(char i : T.toCharArray()) count[i - 'a']++;
        StringBuilder sb = new StringBuilder();
        for(char i : S.toCharArray()) {
            while(count[i-'a']-- > 0) {
                sb.append(i);
            }
        }
        for(int i = 0 ; i < 26;i++){
            while(count[i]-- > 0) {
                sb.append((char)(i + 'a'));
            }
        }
        return sb.toString();
    }
}
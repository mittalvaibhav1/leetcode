
//https://leetcode.com/problems/custom-sort-string/
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
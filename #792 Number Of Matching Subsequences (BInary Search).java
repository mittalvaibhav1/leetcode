//https://leetcode.com/problems/number-of-matching-subsequences/
class Solution {
    HashMap<Character,TreeSet<Integer>> map;
    public int numMatchingSubseq(String S, String[] words) {
        map = new HashMap<>();
        int count = 0;
        int index = 0;
        for(char i : S.toCharArray()) {
            TreeSet<Integer> set = map.getOrDefault(i,new TreeSet<Integer>());
            set.add(index);
            map.put(i,set);
            index++;    
        }
        for(String word : words) {
            if(isSubsequence(word)) {
                count++;
            }
        }
        return count;
    }
    public boolean isSubsequence(String word) {
        int pos = -1;
        for(char i : word.toCharArray()) {
            TreeSet<Integer> set = map.get(i);
            try{
                pos = set.higher(pos);
            }
            catch(Exception ex){
                pos =-1;
            }
            if(pos == -1) {
                return false;
            }
        }
        return true;
    }
}
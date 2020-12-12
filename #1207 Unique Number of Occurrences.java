//https://leetcode.com/problems/unique-number-of-occurrences/
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : arr) {
            map.put(i, map.getOrDefault(i,0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if(set.contains(val)) return false;
            else set.add(val);
        }
        return true;
    }
}
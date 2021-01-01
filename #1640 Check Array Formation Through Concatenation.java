//https://leetcode.com/problems/check-array-formation-through-concatenation/
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < pieces.length ; i++) {
            map.put(pieces[i][0],i);
        }
        int i = 0;
        for(i = 0 ; i < arr.length ;) {
            if(!map.containsKey(arr[i])) return false;
            int[] tmp = pieces[map.get(arr[i])];
            for(int j = 0 ; j < tmp.length ; j++) {
                if(tmp[j] != arr[i]) return false;
                i++;
            }
        }
        return i >= arr.length;
    }
}
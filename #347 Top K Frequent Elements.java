//https://leetcode.com/problems/top-k-frequent-elements/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> tmp = new ArrayList<>(nums.length);
        int[] res = new int[k];
        for(int i : nums) {
            if(map.containsKey(i)) {
                map.put(i,map.get(i) + 1);
            }
            else {
                map.put(i,1);
                tmp.add(i);
            }
        }
        Collections.sort(tmp,(a,b)->Integer.compare(map.get(b),map.get(a)));
        for(int i =0 ; i < k ; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }
}
//https://leetcode.com/problems/remove-covered-intervals/
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int[] pair : intervals) {
            if(map.containsKey(pair[0])){
                map.put(pair[0],Math.max(pair[1],map.get(pair[0])));
            }
            else {
                try {
                    int prev = map.floorKey(pair[0]);
                    if(map.get(prev) >= pair[1]) {
                        continue;
                    }
                    else {
                        map.put(pair[0],pair[1]);
                    }
                }
                catch(Exception ex) {
                    map.put(pair[0],pair[1]);
                }
                try {
                    while(true) {
                        int next = map.ceilingKey(pair[0]+1);
                        if(map.get(next) <= pair[1]) {
                            map.remove(next);
                        }
                        else {
                            break;
                        }
                    }
                }
                catch(Exception ex) {
                    continue;
                }
            }
        }
        //System.out.println(map);
        return map.size();
    }
}
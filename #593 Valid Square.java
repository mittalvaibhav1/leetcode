//https://leetcode.com/problems/valid-square/
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double d1 = calDistance(p1,p2);
        double d2 = calDistance(p1,p3);
        double d3 = calDistance(p1,p4);
        double d4 = calDistance(p2,p3);
        double d5 = calDistance(p2,p4);
        double d6 = calDistance(p3,p4);
        HashMap<Double,Integer> map = new HashMap<>();
        map.put(d1,map.getOrDefault(d1,0) + 1);
        map.put(d2,map.getOrDefault(d2,0) + 1);
        map.put(d3,map.getOrDefault(d3,0) + 1);
        map.put(d4,map.getOrDefault(d4,0) + 1);
        map.put(d5,map.getOrDefault(d5,0) + 1);
        map.put(d6,map.getOrDefault(d6,0) + 1);
        
        if(map.size() > 2) return false;
        boolean isFour = false;
        boolean isTwo = false;
        for(Map.Entry<Double,Integer> entry :  map.entrySet()) {
            if(entry.getValue() == 4) isFour = true;
            if(entry.getValue() == 2) isTwo = true;
        }
        return isFour && isTwo;
        
    }
    public double calDistance(int[] p1 , int[] p2) {
        int x = p2[0] - p1[0];
        int y = p2[1] - p1[1];
        double res = Math.sqrt((x * x) + (y * y));
        return res;
    }
}
//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
//M1 16ms
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : time) {
            map.put(i % 60 , map.getOrDefault(i % 60, 0) + 1);
        }
        int count = 0;
        for(int i = 0 ; i < time.length ; i++) {
            int rem = time[i] % 60;
            int val = map.get(rem);
            if(val == 1) map.remove(rem);
            else map.put(rem,val-1);
            int req = 60 - rem;
            if(map.containsKey(req % 60)) {
                count += map.get(req % 60);
            }
        }
        return count;
    }
}
// M2 4ms
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] map = new int[60];
        for(int i : time) {
            map[i % 60]++;
        }
        int count = 0;
        for(int i = 0 ; i < time.length ; i++) {
            int rem = time[i] % 60;
            map[rem]--;
            int req = 60 - rem;
            count += map[req % 60];
        }
        return count;
    }
}
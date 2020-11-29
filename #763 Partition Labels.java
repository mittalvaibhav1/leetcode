//https://leetcode.com/problems/partition-labels/
// M1 5ms
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        HashMap<Character , Integer> map  = new HashMap<>();
        for(int i  = 0 ; i < S.length() ; i++) {
            map.put(S.charAt(i) , i);
        }
        int dist = 0;
        int len  = 0;
        for(int i  = 0 ; i < S.length() ; i++) {
            dist  = Math.max(map.get(S.charAt(i)) , dist);
            len++;
            if(dist == i) {
                res.add(len);
                len = 0;
            }
        }
        return res;
    }
}
//M2 3ms
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        int[] index = new int[26];
        for(int i  = 0 ; i < S.length() ; i++) {
            index[S.charAt(i) - 'a'] = i;
        }
        int dist = 0;
        int len  = 0;
        for(int i  = 0 ; i < S.length() ; i++) {
            dist  = Math.max(index[S.charAt(i) - 'a'] , dist);
            len++;
            if(dist == i) {
                res.add(len);
                len = 0;
            }
        }
        return res;
    }
}
//M3 2ms
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        int length = S.length();
        int[] index = new int[26];
        for(int i  = 0 ; i < length ; i++) {
            index[S.charAt(i) - 'a'] = i;
        }
        int dist = 0;
        int len  = 0;
        for(int i  = 0 ; i < length ; i++) {
            dist  = Math.max(index[S.charAt(i) - 'a'] , dist);
            len++;
            if(dist == i) {
                res.add(len);
                len = 0;
            }
        }
        return res;
    }
}

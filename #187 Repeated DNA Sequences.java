//https://leetcode.com/problems/repeated-dna-sequences/
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10) return new ArrayList<String>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0 ; i + 9 < s.length() ; i++) {
            String val = s.substring(i,i+10);
            map.put(val,map.getOrDefault(val,0)+1);
        }
        List<String> res = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
//https://leetcode.com/problems/top-k-frequent-words/
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>(k);
        List<String> tmp = new ArrayList<>(words.length);
        for(String word : words) {
            if(map.containsKey(word)) {
                 map.put(word,map.get(word) + 1);
            }
            else {
                map.put(word,1);
                tmp.add(word);
            }
        }
        Collections.sort(tmp , (a,b) -> map.get(a) == map.get(b) ? a.compareTo(b) : Integer.compare(map.get(b),map.get(a)));
        for(int i = 0 ; i < k ; i++) {
            res.add(tmp.get(i));
        }
        return res;
    }
}
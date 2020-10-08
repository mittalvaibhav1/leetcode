//https://leetcode.com/problems/number-of-matching-subsequences/
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        ArrayList<Node> buckets[] = new ArrayList[26];
        for(int i = 0 ; i < 26 ; i++) {
            buckets[i] = new ArrayList<>();
        }
        for(String word : words) {
            buckets[word.charAt(0) - 'a'].add(new Node(word,0));
        }
        int ans = 0;
        for(char i : S.toCharArray()) {
            ArrayList<Node> currBucket = buckets[i-'a'];
            buckets[i-'a'] = new ArrayList<>();
            for(Node n : currBucket) {
               n.index++;
               if(n.index == n.word.length()) {
                   ans++;
               }
               else {
                   buckets[n.word.charAt(n.index)-'a'].add(n);
               } 
            }
        }
        return ans;
    }
}
class Node {
    String word;
    int index;
    public Node(String word , int index) {
        this.word = word;
        this.index = index;
    }
}
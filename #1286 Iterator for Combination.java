//https://leetcode.com/problems/iterator-for-combination/
class CombinationIterator {
    LinkedList<String> q ;
    public CombinationIterator(String characters, int combinationLength) {
        q = new LinkedList<>();
        char[] chars = characters.toCharArray();
        helper(chars,combinationLength,new StringBuilder(),0);
    }
    public void helper(char[] chars, int k, StringBuilder sb, int start) {
        if(k == 0) {
            q.add(sb.toString());
            return;
        }
        else {
            for(int i = start; i < chars.length ; i++) {
                int n = sb.length();
                sb.append(chars[i]);
                helper(chars,k-1,sb,i+1);
                sb.setLength(n);
            }
        }
    }
    
    public String next() {
        return q.poll();
    }
    
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
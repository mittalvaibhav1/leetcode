//https://leetcode.com/problems/the-kth-factor-of-n/
class Solution {
    public int kthFactor(int n, int k) {
        int j = 0;
        for(int i  = 1 ; i <= n ; i++) {
            if(n % i == 0) j++;
            if(j == k) return i;
        }
        return -1;
    }
}
//M2 O(SQRTN)
class Solution {
    public int kthFactor(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int sqrt = (int)Math.sqrt(n);
        int c = 0;
        for(int i = 1 ; i <= sqrt ; i++) {
            if(n % i == 0) {
                c++;
                if(i * i != n) list.addFirst(n / i);
                if(c == k) return i;
            }
        }
        if(c + list.size() < k) return -1;
        else return list.get(k - (c + 1));
    }
}
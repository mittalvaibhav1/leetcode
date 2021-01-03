//https://leetcode.com/problems/beautiful-arrangement/

// M1 - O(n) - 63ms

class Solution {
    int res;
    public int countArrangement(int n) {
        res = 0;
        helper(n,new boolean[n+1],1);
        return res;
    }
    public void helper(int n, boolean[] used, int pos) {
        if(pos > n) {
            res++;
            return;
        }
        for(int i = 1 ; i <= n ; i++) {
            if(used[i]) continue;
            if(i % pos == 0 || pos % i == 0) {
                used[i] = true;
                helper(n,used,pos+1);
                used[i] = false;
            }
        }
    }
}

// M2 - O(n) - 7ms
// Start from back because samller numbers have a greater chance of being divisible among themseleves!

class Solution {
    int res;
    public int countArrangement(int n) {
        res = 0;
        helper(n,new boolean[n+1],n);
        return res;
    }
    public void helper(int n, boolean[] used, int pos) {
        if(pos < 1) {
            res++;
            return;
        }
        for(int i = n ; i >= 1 ; i--) {
            if(used[i]) continue;
            if(i % pos == 0 || pos % i == 0) {
                used[i] = true;
                helper(n,used,pos-1);
                used[i] = false;
            }
        }
    }
}
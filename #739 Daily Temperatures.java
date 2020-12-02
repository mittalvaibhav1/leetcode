//https://leetcode.com/problems/daily-temperatures/
class Solution {
    class Pair {
        int temp;
        int idx;
        public Pair(int temp , int idx) {
            this.temp = temp;
            this.idx = idx;
        }
    }
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        int k = 0;
        ArrayDeque<Pair> stack = new ArrayDeque<>(T.length);
        stack.push(new Pair(T[0],0));
        for(int i  = 1 ; i < T.length; i++) {
            while(!stack.isEmpty() && stack.peek().temp < T[i]) {
                int idx = stack.pop().idx;
                res[idx] = i - idx ;
            }
            stack.push(new Pair(T[i],i));
        }
        while(!stack.isEmpty()) {
            res[stack.pop().idx] = 0;
        }
        return res;
    }
}
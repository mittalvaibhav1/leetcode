//https://leetcode.com/problems/jump-game-iii
class Solution {
    public boolean canReach(int[] arr, int start) {
        return helper(arr,start , new boolean[arr.length]);
    }
    public boolean helper(int[] arr , int idx , boolean[] visited) {
        if(idx < 0 || idx > arr.length - 1) return false;
        if(arr[idx] == 0) return true;
        if(visited[idx]) return false;
        visited[idx] = true;
        return helper(arr, idx + arr[idx] , visited) || helper(arr, idx - arr[idx] , visited);
        
    }
}
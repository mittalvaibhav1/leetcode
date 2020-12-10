//https://leetcode.com/problems/valid-mountain-array/
class Solution {
    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        if(len < 3) return false;
        int i = 0;
        boolean up = false , down = false;
        while(i < len - 1 && arr[i + 1] > arr[i]) {
            i++;
            up = true;
        }
        while(i < len - 1 && arr[i + 1] < arr[i]) {
            i++;
            down = true;
        }
        return i == len - 1 && up && down; 
        
    }
}
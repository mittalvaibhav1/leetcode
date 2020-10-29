//https://leetcode.com/problems/maximize-distance-to-closest-person/
class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] left = new int[seats.length];
        int[] right = new int[seats.length];
        int count = 1;
        for(int i = 0 ; i < seats.length ; i++) {
            left[i] = count;
            if(seats[i] == 0) count++;
            else count = 1;
        }
        count = 1;
        for(int i = seats.length - 1 ; i >= 0 ; i--) {
            right[i] = count;
            if(seats[i] == 0) count++;
            else count = 1;
        }
        int sum = 0;
        int ans = 0;
        for(int i = 0 ; i < seats.length ; i++) {
            if(seats[i] == 0) {
                int currSum = left[i] + right[i];
                if(currSum >= sum) {
                    sum = currSum;
                    if(i!=0 && i!= (seats.length -1))
                    ans = Math.max(ans,Math.min(right[i],left[i]));
                }
                if(i == 0) ans = Math.max(ans,right[i]);
                if(i == (seats.length -1)) ans = Math.max(ans,left[i]);
            }
        }
        return ans;
    }
}
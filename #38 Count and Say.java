//https://leetcode.com/problems/count-and-say/
class Solution {
    public String countAndSay(int n) {
     String nth = "1";
     for(int i = 1 ; i < n ; i++) {
         char[] arr = nth.toCharArray();
         StringBuilder term = new StringBuilder();
         char curr = arr[0];
         int count = 1;
         for(int j = 1 ; j < arr.length  ; j++) {
             if(arr[j] == curr) {
                 count++;
             }
             else {
                 term.append(count).append(curr);
                 count=1;
                 curr=arr[j];
             }
         }
         term.append(count).append(curr);
         nth = term.toString();
     }
     return nth;   
    }
}
//https://leetcode.com/problems/reverse-string-ii/
class Solution {
    public String reverseStr(String s, int k) {
       char[] arr = s.toCharArray();
       int start = 0;
       int end = -1;
       int count = 0; 
       while(end < arr.length) {
           start = end + 1;
           end = start + (k-1);
           if(end > arr.length -1){
               end = arr.length - 1;
               if(start > end) {
                   break;
               }
           }
           if(count%2 == 0) {
               reverse(arr,start,end);
           }
           count++;
       } 
       return new String(arr); 
    }
    public void reverse(char[] arr , int start , int end) {
        while(start < end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}
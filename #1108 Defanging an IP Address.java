//https://leetcode.com/problems/defanging-an-ip-address/
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        int len = address.length();
        for(int i = 0 ; i < len ; i++) {
            if(address.charAt(i) == '.') {
                sb.append('[').append('.').append(']'); 
            }
            else {
                sb.append(address.charAt(i)); 
            }
        }
        return sb.toString();
    }
}
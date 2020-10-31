//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
class Solution {
    public int minAddToMakeValid(String S) { 
        while(S.contains("()"))
        S = S.replaceAll("\\(\\)","");
        return S.length();
    }
}

// M2

class Solution {
    public int minAddToMakeValid(String S) { 
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for(int i = 0 ; i <S.length(); i++) {
            if(S.charAt(i) == '(') {
                st.push('(');
            }
            else if(!st.isEmpty() && st.peek() == '(') {
                st.pop();
            }
            else {
                if(!st.isEmpty()){
                    st.pop();
                    ans++;
                }
                ans++;;
            }
        }
        return ans + st.size();
    }
}

//M3

class Solution {
    public int minAddToMakeValid(String S) { 
        char[] st = new char[S.length()];
        int head = -1;
        int ans = 0;
        for(int i = 0 ; i <S.length(); i++) {
            if(S.charAt(i) == '(') {
                st[++head] = '(';
            }
            else if(head!= -1 && st[head] == '(') {
                head--;
            }
            else {
                if(head != -1){
                    head--;
                    ans++;
                }
                ans++;
            }
        }
        return ans + head + 1;
    }
}
class Solution {
    public String longestPalindrome(String s) {
        int size = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        if(s.equals(rev))
            return rev;
        ArrayListArrayListInteger al = new ArrayList();
        ArrayListInteger tmp = new ArrayList();
        
        for(int i=0;i=size;i++)
            tmp.add(0);
        al.add(tmp);
    
        for(int i=size-1;i=0;i--)
        {
            tmp = new ArrayListInteger();
            for(int j=size; j=0;j--)
            {
                if(j==size)
                    tmp.add(0);
                else if(s.charAt(i)!=rev.charAt(j))
                    tmp.add(0,0);
                else
                {
                   ArrayListInteger tmp2 = al.get(0);
                   tmp.add(0,1+tmp2.get(j+1)); 
                }
            }
            al.add(0,tmp);
        }
        String out = ;
        int max = 0 , index = 0;
        for(int i = 0; isize;i++)
        {
            tmp = al.get(i);
            for(int j = 0;jsize;j++)
            {  int val = tmp.get(j);
                if(valmax)
                {
                    String t =rev.substring(j,j+val) ;
                    String t2 = s.substring(size-j-val,size-j);
                    if(t.equals(t2))
                    {max = val;
                    index = j;
                    out=t;}
                }
            }
        }
     return out;   
    }
}
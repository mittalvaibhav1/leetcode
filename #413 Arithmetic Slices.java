//https://leetcode.com/problems/arithmetic-slices/
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int size = A.length;     
        if(size < 3) {
            return 0;
        }
        HashMap<Integer,Integer> lengths = new HashMap<>();
        int currDiff = A[0] - A[1];
        int currLen = 2;
        for(int i  = 1 ; i < size - 1 ; i++) {
            if(A[i] - A[i+1] == currDiff) {
                currLen++;
                if(currLen >= 3) {
                    int len = currLen;
                    while(len>=3) {
                        lengths.put(len,lengths.getOrDefault(len,0)+1);
                        len--;
                    }   
                }
            }
            else {
                currDiff = A[i] -A[i+1];
                currLen = 2;
            }
        }
        int sum = 0;
        for(Map.Entry<Integer,Integer> entry : lengths.entrySet()) {
            sum += entry.getValue();
        }
        return sum;
    }
}
//https://leetcode.com/problems/sort-characters-by-frequency/
class Solution {
    public class Pair {
        int count;
        char character;
        public Pair(int count , char character) {
            this.count = count;
            this.character = character;
        }
    }
    public String frequencySort(String s) {
        StringBuilder res = new StringBuilder();
        Pair[] arr =  new Pair[256];
        for(int i  = 0 ; i < 256 ; i++) {
            arr[i] = new Pair(0 , (char)(i));
        }
        char[] string = s.toCharArray();
        for(int i  = 0 ; i < string.length ; i++) {
                arr[string[i]].count++;
        }
        Arrays.sort(arr,(a,b) -> Integer.compare(b.count,a.count));
        for(int i  = 0 ; i < arr.length ; i++) {
            while(arr[i].count -- > 0) {
                res.append(arr[i].character);
            }
        }
        return res.toString();
    }
}
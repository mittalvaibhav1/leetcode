//https://leetcode.com/problems/relative-sort-array/
//M1
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr1.length; i++) {
            if(map.containsKey(arr1[i])) map.put(arr1[i],map.get(arr1[i]) + 1);
            else map.put(arr1[i],1);
        }
        int k = 0;
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i : arr2) {
            int n = map.get(i);
            while(n-- > 0) {
                arr1[k++] = i;
            }
            map.put(i,0);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int n = entry.getValue();
            while(n-- > 0) {
                tmp.add(entry.getKey());
            }
        }
        Collections.sort(tmp);
        for(int i : tmp) {
            arr1[k++] = i;
        }
        return arr1;
    }
}
// M2
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];
        for(int i = 0 ; i < arr1.length; i++) {
           map[arr1[i]]++;
        }
        int k = 0;
        for(int i : arr2) {
            while(map[i]-- > 0) {
                arr1[k++] = i;
            }
        }
        for(int i = 0 ; i < 1001 ; i++) {
            while(map[i]-- > 0) {
                arr1[k++] = i;
            }
        }
        return arr1;
    }
}
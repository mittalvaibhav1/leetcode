//https://leetcode.com/problems/number-of-recent-calls/
class RecentCounter {
    ArrayList<Integer> recentRequestes;
    int index = 0;
    public RecentCounter() {
        recentRequestes = new ArrayList<>();
    } 
    public int ping(int t) {
        recentRequestes.add(t);
        index = binarySearch(recentRequestes,t);
     return recentRequestes.size() - index;   
    }
    
    public int binarySearch(List<Integer> recentRequestes, int t) {
        int left = index;
        int right = recentRequestes.size() - 1;
        
        while(left < right) {    
            int mid = (left+right)/2;
            if(t - recentRequestes.get(mid) == 3000) {
                return mid;
            }
            else if(t - recentRequestes.get(mid) > 3000) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return right;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
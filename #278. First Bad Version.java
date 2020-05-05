
//https://leetcode.com/problems/first-bad-version/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int low = 1;
        int high = n;
        
        while(low<=high)
        {
            int mid = low + (high-low) / 2;
            
            if(isBadVersion(mid) == true && isBadVersion(mid-1)==false)
            {
                return mid;
            }
            else if(isBadVersion(mid) == false)
            {
                low = mid + 1;
            }
            else
            {
                high = mid -1;
            }
        }
        
        return 0;
    }
}
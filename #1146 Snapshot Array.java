//https://leetcode.com/problems/snapshot-array/
class SnapshotArray {
    int[] array;
    int totalSnaps;
    int maxIndexSet;
    HashMap<Integer,int[]> snapShots;
    public SnapshotArray(int length) {
        array = new int[length];
        snapShots = new HashMap<>();
        totalSnaps = 0;
        maxIndexSet = 0;
    }
    
    public void set(int index, int val) {
        array[index] = val;
        maxIndexSet = Math.max(maxIndexSet,index);
    }
    
    public int snap() {
        snapShots.put(totalSnaps,Arrays.copyOf(array,maxIndexSet + 1));
        //System.out.println(Arrays.toString(array));
        return totalSnaps++;
    }
    
    public int get(int index, int snap_id) {
        int[] tmp =  snapShots.get(snap_id);
        return tmp.length > index ? tmp[index] : 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
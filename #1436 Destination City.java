//https://leetcode.com/problems/destination-city/
class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> source = new HashSet<>();
        HashSet<String> destination = new HashSet<>();
        for(List<String> path : paths) {
            source.add(path.get(0));
            destination.add(path.get(1));
        }
        destination.removeAll(source);
        return destination.iterator().next();
    }
}
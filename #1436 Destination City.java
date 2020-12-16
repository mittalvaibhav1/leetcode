//https://leetcode.com/problems/destination-city/
//M1 using 2 sets
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
//M2 using single set
class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> source = new HashSet<>();
        for(List<String> path : paths) {
            source.add(path.get(0));
        }
        for(List<String> path : paths) {
            String city = path.get(1);
            if(!source.contains(city)) return city;
        }
        
        return null;
    }
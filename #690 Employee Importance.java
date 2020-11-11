//https://leetcode.com/problems/employee-importance/
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer,Employee> map;
    int res = 0;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        Iterator<Employee> it = employees.iterator();
        while(it.hasNext()) {
            Employee tmp = it.next();
            map.put(tmp.id,tmp);
        }
        helper(map.get(id));
        return res;
    }
    public void helper(Employee emp) {
        res += emp.importance;
        Iterator<Integer> it = emp.subordinates.iterator();
        while(it.hasNext()) {
            helper(map.get(it.next()));
        } 
    }
}
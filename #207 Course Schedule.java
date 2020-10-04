//https://leetcode.com/problems/course-schedule/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer> adjList[] = new LinkedList[numCourses];
        for(int[] pair : prerequisites) {
            int u = pair[1];
            int v = pair[0];
            if(adjList[u] == null) {
                adjList[u] = new LinkedList<>();
            }
            adjList[u].add(v);
        }
        int[] visited = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++) {
            if(visited[i] == 0) {
                if(dfs(i,visited,adjList)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int i , int[] visited , LinkedList<Integer> adjList[]) {
        visited[i] = 1;
        if(adjList[i] != null) {
            Iterator<Integer> it = adjList[i].iterator();
            while(it.hasNext()) {
                int curr = it.next();
                if(visited[curr] == 1) return true; //cycle
                if(visited[curr] == 0 && dfs(curr,visited,adjList)) {
                    return true;
                }
            }
        }
        visited[i] = 2;
        return false;
    }
}
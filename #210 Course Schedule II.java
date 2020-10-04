//https://leetcode.com/problems/course-schedule-ii/submissions/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses);
        for(int[] pair : prerequisites) {
            g.addEdge(pair[1],pair[0]);
        }
        int[] res = g.topSort();
        return res;
    }
}
class Graph {
    int vertices;
    LinkedList<Integer> adjList[];
    public Graph(int v) {
        this.vertices = v;
        this.adjList = new LinkedList[vertices];
        for(int i = 0 ; i < vertices ; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int u , int v) {
        adjList[u].add(v);
    }
    public boolean dfs(int i , boolean[] visited , ArrayList<Integer> order, boolean[] recStack){
        visited[i] = true;
        recStack[i] = true;
        Iterator<Integer> it = adjList[i].iterator();
        while(it.hasNext()) {
            int curr = it.next();
            if(!visited[curr]) {
                if(dfs(curr,visited,order,recStack))
                    return true;
            }
            else {
                if(recStack[curr] == true) {
                    return true;
                }
            }
        }
        recStack[i] = false;
        order.add(i);
        return false;
    }
    public int[] topSort() {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];
        int[] sorted = new int[vertices];
        int c = vertices - 1;
        for(int i = 0 ; i < vertices ; i++) {
            if(!visited[i]) {
                ArrayList<Integer> order = new ArrayList<>();
                if(dfs(i,visited,order,recStack)){
                    return new int[0];
                }
                for(int j = 0 ; j < order.size() ; j++) {
                    sorted[c--] = order.get(j);
                }
            }
        }
        return sorted;
    }
}
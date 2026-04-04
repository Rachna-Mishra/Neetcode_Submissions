class Solution {
     public int countComponents(int n, int[][] edges) {
        int count = 0;
        ArrayList<Integer>[] adjList = new ArrayList[n];
        for(int i = 0; i<n; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<edges.length; i++){
            int src = edges[i][0];
            int des = edges[i][1];
            adjList[src].add(des);
            adjList[des].add(src);
        } 
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(n, adjList, i, vis);
                count++;
            }
        }
        return count;
    }
    public void dfs(int n, ArrayList<Integer>[] adjList, int cur, boolean[] vis){
        vis[cur] = true;
        for(int i = 0; i < adjList[cur].size(); i++){
            int neighbor = adjList[cur].get(i);
            if(!vis[neighbor]){
                dfs(n, adjList, neighbor, vis);
            }
        }
    }
}

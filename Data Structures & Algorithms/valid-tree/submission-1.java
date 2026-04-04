class Solution {
    public boolean validTree(int n, int[][] edges) {
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
        if(isCycleExist(n, adjList, 0, vis, -1)){
            return false;
        }
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                return false;
            }
        }
        return true;
    }
    public boolean isCycleExist(int n, ArrayList<Integer>[] adjList, int cur, boolean[] vis, int par){
        vis[cur] = true;
        for(int i = 0; i < adjList[cur].size(); i++){
            int neighbor = adjList[cur].get(i);
            if(vis[neighbor] && neighbor != par){
                return true;
            }
            if(!vis[neighbor] && isCycleExist(n, adjList, neighbor, vis, cur)){
                return true;
            }
        }
        return false;
    }
}

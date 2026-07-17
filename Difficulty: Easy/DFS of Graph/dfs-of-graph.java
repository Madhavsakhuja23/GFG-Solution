class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();
        int vis[] = new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i, vis, ans, adj);
            }
        }
        return ans;
    }
    public void dfs(int node, int vis[], ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj){
        ans.add(node);
        vis[node]=1;
        for(int it: adj.get(node)){
            if(vis[it]==0){
                vis[it]=1;
                dfs(it,vis,ans,adj);
            }
        }
    }
}
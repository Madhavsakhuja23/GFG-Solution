class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int visited[] = new int[adj.size()];
        for(int i=0;i<adj.size();i++){
            for(int it: adj.get(i)){
                if(visited[i]==0){
                    dfs(i, adj, visited, ans);
                }
            }
        }
        return ans;
    }
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int visited[], ArrayList<Integer> ans){
        visited[node]=1;
        ans.add(node);
        for(int it: adj.get(node)){
            if(visited[it]==0){
                dfs(it, adj,visited,ans);
            }
        }
    }
}
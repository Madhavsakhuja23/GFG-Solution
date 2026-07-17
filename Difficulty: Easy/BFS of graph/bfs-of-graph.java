class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        int vis[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0]=1;
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int it : adj.get(node)){
                if(vis[it]==0){
                    vis[it]=1;
                    q.add(it);
                }
            }
            
        }
        return ans;
    }
}

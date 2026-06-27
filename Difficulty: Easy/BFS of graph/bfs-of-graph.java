class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int visited[] = new int[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0]=1;
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int it: adj.get(node)){
                if(visited[it]==0){
                    q.add(it);
                    visited[it]=1;
                }
            }
        }
        return ans;
    }
}
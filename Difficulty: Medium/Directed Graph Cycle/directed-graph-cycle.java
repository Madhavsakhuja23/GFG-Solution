class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        int indegree[] = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
        }
        for(int i=0;i<V;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q  = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int cnt=0;
        while(!q.isEmpty()){
            int n = q.poll();
            cnt++;
            for(int it: adj.get(n)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(cnt==V){
            return false;
        }
        return true;
    }
}
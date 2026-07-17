class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int visited[] = new int[V];
        
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(detectCycle(i, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean detectCycle(int node,ArrayList<ArrayList<Integer>> adj , int vis[] ){
        vis[node]=1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int no = curr.n;
            int pn = curr.Parentn;
            
            for(int it: adj.get(no)){
                if(vis[it]==0){
                    vis[it]=1;
                    q.add(new Pair(it, no));
                }
                else if(it!=pn){
                    return true;
                }
            }
        }
        return false;
    }
}
class Pair{
    int n;
    int Parentn;
    Pair(int no, int pn){
        n=no;
        Parentn=pn;
    }
}
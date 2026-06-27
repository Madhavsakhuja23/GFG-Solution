class Pair{
    int first;
    int second;

    Pair(int f, int s){
        first=f;
        second=s;
        }
}
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u =edges[i][0];
            int v =edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int visited[] = new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(detectCycle(i, adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean detectCycle(int node, ArrayList<ArrayList<Integer>> adj, int visited[]){
        visited[node]=1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));
        while(!q.isEmpty()){
            int f=q.peek().first;
            int parent=q.peek().second;
            q.remove();
            for(int it: adj.get(f)){
                if(visited[it]==0){
                    visited[it]=1;
                    q.add(new Pair(it,f));
                }else if(it!=parent){
                    return true;
                }
            }
        }
        return false;
    }
}
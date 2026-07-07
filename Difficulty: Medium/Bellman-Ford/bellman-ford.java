class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int dis[] = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src]=0;
        for(int i=0;i<V-1;i++){
            for(int it[] : edges){
                int u = it[0];
                int v = it[1];
                int wt = it[2];
                if(dis[u]!=Integer.MAX_VALUE && wt+dis[u] < dis[v]){
                    dis[v] = wt+dis[u];
                }
            }
        }
        // for detecting the negatvie cycle 
        
        for(int it[] : edges){
            int u=it[0];
            int v=it[1];
            int wt=it[2];
            if(dis[u]!=Integer.MAX_VALUE && wt+dis[u] < dis[v]){
                int temp[] = new int[1];
                temp[0]=-1;
                return temp;
            }
        }
        for(int i=0;i<V;i++){
            if(dis[i]==Integer.MAX_VALUE){
                dis[i]=(int)(1e8);
            }
        }
        return dis;
    }
}

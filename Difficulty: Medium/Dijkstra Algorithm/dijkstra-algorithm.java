class Pair{
    int node;
    int distance;
    Pair(int n, int d){
        node = n;
        distance=d;
    }
}
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.distance-y.distance);
        int dis[] = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src]=0;
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            int di = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();
            
            for(Pair it: adj.get(node)){
                int wt = it.distance;
                int n = it.node;
                if(di + wt < dis[n]){
                    dis[n]=di+wt;
                    pq.add(new Pair(n, di+wt));
                }
            }
        }
        return dis;
    }
}
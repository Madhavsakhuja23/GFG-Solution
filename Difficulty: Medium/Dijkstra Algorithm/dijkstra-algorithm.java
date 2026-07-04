class Pair{

    int node;
    int d;
    Pair(int y, int di){
        node=y;
        d=di;
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
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.d-b.d);
        int dis[] = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src]=0;
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int n = curr.node;
            int di = curr.d;
            for(Pair it: adj.get(n)){
                int adjNode = it.node;
                int adjWt = it.d;
                if(adjWt+di < dis[adjNode]){
                    dis[adjNode]=adjWt+di;
                    pq.add(new Pair(adjNode, dis[adjNode]));
                }
            }
        }
        return dis;
    }
}
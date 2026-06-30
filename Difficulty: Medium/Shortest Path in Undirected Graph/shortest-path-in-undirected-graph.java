class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int dis[] = new int[V];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<Integer> q =  new LinkedList<>();
        q.add(src);
        dis[src]=0;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it: adj.get(node)){
                if(dis[node]+1<dis[it]){
                    dis[it]=dis[node]+1;
                    q.add(it);
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dis[i]==Integer.MAX_VALUE){
                dis[i]=-1;
            }
        }
        return dis;
    }
}

class Solution {
    public int shortestPath(int v, int[][] edges, int src, int dest) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int V = edges[i][1];
            adj.get(u).add(V);
            adj.get(V).add(u);
        }
        int dis[] = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
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
        if(dis[dest]==Integer.MAX_VALUE){
            return -1;
        }
        return dis[dest];
    }
}
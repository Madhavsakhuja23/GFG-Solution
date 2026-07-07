class Pair{
    int node;
    int stps;
    Pair(int n, int s){
        node = n;
        stps=s;
    }
}
class Solution {
    public int minSteps(int[] arr, int start, int end) {
        // code here
        if(start==end){
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        int dis[] = new int[1000];
        Arrays.fill(dis, Integer.MAX_VALUE);
        q.add(new Pair(start, 0));
        dis[start] = 0;
q.add(new Pair(start, 0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int n = curr.node;
            int stps = curr.stps;
           
            for(int it: arr){
                int ans = (n*it)%1000;
                if(ans==end){
                    return stps+1;
                }
                if(stps+1<dis[ans]){
                    dis[ans]=stps+1;
                    q.add(new Pair(ans, stps+1));
                }
            }
        }
        return -1;
    }
}

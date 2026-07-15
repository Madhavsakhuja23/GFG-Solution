class DisjointSet{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
        
    }
    public int findUParent(int node){
        if(parent.get(node)==node){
            return node;
        }
        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void unionBySize(int u, int v){
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        
        if(ulp_u==ulp_v){
            return ;
        }
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u)+size.get(ulp_v));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u)+size.get(ulp_v));
        }
    }
    
}
class Solution {

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        // Your code here
        DisjointSet ds  = new DisjointSet(rows*cols);
        int vis[][] = new int[rows][cols];
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<operators.length;i++){
            int row = operators[i][0];
            int col = operators[i][1];
            
            if(vis[row][col]==1){
                ans.add(cnt);
                continue;
            }
            
            vis[row][col]=1;
            cnt++;
            int mrow[] = {-1,0,1,0};
            int mcol[] ={0,1,0,-1};
            for(int j=0;j<4;j++){
                int adjro = row+mrow[j];
                int adjco = col+mcol[j];
                if(adjro >=0 && adjro<rows && adjco >=0 && adjco <cols){
                    if(vis[adjro][adjco]==1){
                        int nodeNo= row*cols+col;
                        int adjnodeNo = adjro*cols+adjco;
                        if(ds.findUParent(nodeNo) != ds.findUParent(adjnodeNo)){
                            cnt--;
                            ds.unionBySize(nodeNo, adjnodeNo);
                        }
                        
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
}
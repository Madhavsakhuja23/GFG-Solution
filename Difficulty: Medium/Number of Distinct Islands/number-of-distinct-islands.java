class Solution {
    public int countDistinctIslands(char[][] grid) {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        int visited[][] = new int[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]=='L'){
                    ArrayList<String> shape = new ArrayList<>();
                    bfs(i,j,visited,grid,i,j,shape);
                    st.add(shape);
                }
            }
        }
        return st.size();
    }
    public void bfs(int row, int col, int visited[][], char grid[][], int row0, int col0, ArrayList<String> shape){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        visited[row][col]=1;
        int mrow[] = {-1,0,1,0};
        int mcol[] = {0,1,0,-1};
        int n = grid.length;
        int m = grid[0].length;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            shape.add(toString(r-row0,c-col0));
            q.remove();
            for(int i=0;i<4;i++){
                int nrow = r+mrow[i];
                int ncol = c+mcol[i];
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && visited[nrow][ncol]==0&& grid[nrow][ncol]=='L'){
                    visited[nrow][ncol]=1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
    public String toString(int r, int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }
}
class Pair{
    int row;
    int col;
    Pair(int r, int c){
        row=r;
        col=c;
    }
}
class DisjointSet {
	ArrayList<Integer> parent = new ArrayList<>();
	ArrayList<Integer> size = new ArrayList<>();
	
	DisjointSet(int n) {
		for (int i = 0; i<n; i++) {
			parent.add(i);
			size.add(1);
		}
	}
	
	public int findUParent(int node) {
		if (parent.get(node) == node) {
			return node;
		}
		int ulp = findUParent(parent.get(node));
		parent.set(node, ulp);
		return parent.get(node);
	}
	
	public void unionBySize(int u, int v) {
		int ulp_u = findUParent(u);
		int ulp_v = findUParent(v);
		
		if (ulp_u == ulp_v) {
			return;
		}
		
		if (size.get(ulp_u) < size.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
			size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
		} else {
			parent.set(ulp_v, ulp_u);
			size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
		}
	}
}
class Edge {
	
	int u;
	int v;
	int wt;
	
	Edge(int u, int v, int wt) {
		this.u = u;
		this.v = v;
		this.wt = wt;
	}
}
class Solution {
	static int kruskalsMST(int V, int[][] edges) {
		// code here
		ArrayList<Edge> edgeList = new ArrayList<>();
		for(int i=0;i<edges.length;i++){
		    edgeList.add(new Edge(edges[i][0], edges[i][1], edges[i][2]));
		}
		Collections.sort(edgeList, (a,b) -> a.wt-b.wt);
		DisjointSet ds = new DisjointSet(V);
		int mstWt = 0;
		for(Edge it : edgeList){
		    int u = it.u;
		    int v = it.v;
		    int wt = it.wt;
		    
		    if(ds.findUParent(u)!=ds.findUParent(v)){
		        mstWt+=wt;
		        ds.unionBySize(u, v);
		    }
		    
		}
		return mstWt;
	}
}

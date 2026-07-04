class Pair {
	int n;
	int d;
	Pair(int nn, int dd) {
		n = nn;
		d = dd;
	}
}
class Solution {
	
	public int[] shortestPath(int V, int E, int[][] edges) {
		// Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		for (int i = 0; i<edges.length; i++) {
			adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
		}
		int dis[] = new int[V];
		Arrays.fill(dis, Integer.MAX_VALUE);
		int visited[] = new int[V];
		Stack<Integer> st = new Stack<>();
		dis[0] = 0;
		for (int i = 0; i<V; i++) {
			if (visited[i] == 0) {
				topoSort(i, adj, visited, st);
			}
		}
		while (!st.isEmpty()) {
			int node = st.pop();
			for (Pair it: adj.get(node)) {
				int v = it.n;
				int wt = it.d;
				if (dis[node] != Integer.MAX_VALUE && dis[node]+wt<dis[v]) {
					dis[v] = dis[node]+wt;
				}
			}
		}
		for (int i = 0; i<V; i++) {
			if (dis[i] == Integer.MAX_VALUE) {
				dis[i] = -1;
			}
		}
		return dis;
	}
	public void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int visited[], Stack<Integer> st) {
		visited[node] = 1;
		for (Pair it: adj.get(node)) {
			int v = it.n;
			if (visited[v] == 0) {
				topoSort(v, adj, visited, st);
			}
		}
		st.push(node);
		
	}
}

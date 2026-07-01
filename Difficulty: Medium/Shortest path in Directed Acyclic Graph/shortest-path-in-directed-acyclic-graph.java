class Pair {
	int node;
	int wt;
	Pair(int n, int w) {
		node = n;
		wt = w;
	}
}
class Solution {
	
	public int[] shortestPath(int V, int E, int[][] edges) {
		// Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i<V; i++) {
			ArrayList<Pair> ar = new ArrayList<>();
			adj.add(ar);
		}
		for (int i = 0; i<E; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int wt = edges[i][2];
			adj.get(u).add(new Pair(v, wt));
		}
		int visited[] = new int[V];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i<V; i++) {
			if (visited[i] == 0) {
				topoSort(i, visited, adj, st);
			}
		}
		int dis[] = new int[V];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[0] = 0;
		while (!st.isEmpty()) {
			int node = st.pop();
			for (Pair it:adj.get(node)) {
				int v = it.node;
				int wt = it.wt;
				
				if (dis[node] != Integer.MAX_VALUE && dis[node] + wt < dis[v]) {
					dis[v] = dis[node] + wt;
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
	public void topoSort(int node, int visited[], ArrayList<ArrayList<Pair>> adj, Stack<Integer> st) {
		visited[node] = 1;
		for (Pair it: adj.get(node)) {
			int v = it.node;
			if (visited[v] == 0) {
				topoSort(v, visited, adj, st);
			}
		}
		st.push(node);
	}
	
}

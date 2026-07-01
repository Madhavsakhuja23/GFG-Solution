class Pair {
	int node;
	int dis;
	Pair(int n, int d) {
		node = n;
		dis = d;
	}
}
class Solution {
	public List<Integer> shortestPath(int n, int m, int edges[][]) {
		//  Code Here.
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<Pair>());
		}
		for (int i = 0; i<m; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int wt = edges[i][2];
			adj.get(u).add(new Pair(v, wt));
			adj.get(v).add(new Pair(u, wt));
		}
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.dis - b.dis);
		pq.add(new Pair(1, 0));
		int dis[] = new int[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[1] = 0;
		int parent[] = new int[n + 1];
		for (int i = 0; i<n + 1; i++) {
			parent[i] = i;
		}
		while (!pq.isEmpty()) {
			Pair curr = pq.peek();
			int node = curr.node;
			int d = curr.dis;
			pq.remove();
			if (d > dis[node]) {
    continue;
}
			
			for (Pair it: adj.get(node)) {
				int adjNode = it.node;
				int weight = it.dis;
				if (d + weight<dis[adjNode]) {
					dis[adjNode] = d + weight;
					pq.add(new Pair(adjNode, dis[adjNode]));
					parent[adjNode] = node;
				}
			}
		}
		List<Integer> ans = new ArrayList<>();
		if (dis[n] == Integer.MAX_VALUE) {
			ans.add(-1);
			return ans;
		}
		int node = n;
		while (parent[node] != node) {
			ans.add(node);
			node = parent[node];
		}
		ans.add(1);
		Collections.reverse(ans);
		ans.add(0, dis[n]);
		return ans;
	}
}

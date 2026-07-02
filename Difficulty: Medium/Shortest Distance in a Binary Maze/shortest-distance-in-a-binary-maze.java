class Pair {
	int dis;
	int i;
	int j;
	Pair(int d, int x, int y) {
		dis = d;
		i = x;
		j = y;
	}
}
class Solution {
	public int shortestPath(int[][] mat, int[] src, int[] dest) {
		// code here
		
		if (mat[src[0]][src[1]] == 0 || mat[dest[0]][dest[1]] == 0) {
			return - 1;
		}
		
		if (src[0] == dest[0] && src[1] == dest[1]) {
			return 0;
		}
		int dist[][] = new int[mat.length][mat[0].length];
		for (int[] row : dist) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, src[0], src[1]));
		dist[src[0]][src[1]] = 0;
		int mrow[] = {-1, 0, 1, 0};
		int mcol[] = {0, 1, 0, -1};
		int n = mat.length;
		int m = mat[0].length;
		while (!q.isEmpty()) {
			int d = q.peek().dis;
			int row = q.peek().i;
			int col = q.peek().j;
			q.poll();
			for (int k = 0; k<4; k++) {
				int nrow = row + mrow[k];
				int ncol = col + mcol[k];
				if (nrow >= 0 && nrow<n && ncol >= 0 && ncol<m && mat[nrow][ncol] == 1 && d + 1<dist[nrow][ncol]) {
					dist[nrow][ncol] = d + 1;
					q.add(new Pair(d + 1, nrow, ncol));
				}
			}
		}
		if (dist[dest[0]][dest[1]] == Integer.MAX_VALUE) {
			return - 1;
		}
		return dist[dest[0]][dest[1]];
	}
}

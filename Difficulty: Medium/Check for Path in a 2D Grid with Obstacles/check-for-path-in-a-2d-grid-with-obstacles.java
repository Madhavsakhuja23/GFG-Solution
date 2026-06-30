class Pair {
	int i;
	int j;
	Pair(int a, int b) {
		i = a;
		j = b;
	}
}
class Solution {
	public boolean isPathPossible(int[][] mat) {
		// Code here
		int n = mat.length;
		int m = mat[0].length;
		int mrow[] = {-1, 0, 1, 0};
		int mcol[] = {0, 1, 0, -1};
		Queue<Pair> q = new LinkedList<>();
		int visited[][] = new int[n][m];
		boolean found = false;
		for (int i = 0; i<n && !found; i++) {
			for (int j = 0; j<m; j++) {
				if (mat[i][j] == 1) {
					q.add(new Pair(i, j));
					visited[i][j]=1;
					found = true;
				}
			}
		}
		while (!q.isEmpty()) {
			int i = q.peek().i;
			int j = q.peek().j;
			q.poll();
			for (int k = 0; k<4; k++) {
				int nrow = i + mrow[k];
				int ncol = j + mcol[k];
				if (nrow >= 0 && nrow<n && ncol >= 0 && ncol<m) {
					
					if (mat[nrow][ncol] == 0) {
						continue;
					}
					
					if (visited[nrow][ncol] == 0) {
						
						if (mat[nrow][ncol] == 2) {
							return true;
						}
						
						if (mat[nrow][ncol] == 3) {
							visited[nrow][ncol] = 1;
							q.add(new Pair(nrow, ncol));
						}
						
					}
				}
			}
		}
		return false;
	}
}

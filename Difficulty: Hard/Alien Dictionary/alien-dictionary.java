class Solution {
	public String findOrder(String[] words) {
		// code here
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i<26; i++) {
			adj.add(new ArrayList<>());
		}
		int indegree[] = new int[26];
		boolean exist[] = new boolean[26];
		for (String word : words) {
			for (char c:word.toCharArray()) {
				exist[c - 'a'] = true;
			}
		}
		for (int i = 0; i<words.length - 1; i++) {
			String s1 = words[i];
			String s2 = words[i + 1];
			
			int len = Math.min(s1.length(), s2.length());
			boolean found = false;
			
			for (int j = 0; j<len; j++) {
				if (s1.charAt(j) != s2.charAt(j)) {
					adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
					indegree[s2.charAt(j) - 'a']++;
					found = true;
					break;
				}
			}
			
			if (!found && s1.length() > s2.length()) {
				return "";
			}
		}
		int total = 0;
		
		for (int i = 0; i<26; i++) {
			if (exist[i]) {
				total++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i<26; i++) {
			if (exist[i] && indegree[i] == 0) {
				q.add(i);
			}
		}
		String ans = "";
		int cnt = 0;
		while (!q.isEmpty()) {
			cnt++;
			int node = q.poll();
			ans = ans + (char)(node + 'a');
			for (int it:adj.get(node)) {
				indegree[it]--;
				if (indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		if (cnt!= total) {
			return "";
		}
		return ans;
	}
}

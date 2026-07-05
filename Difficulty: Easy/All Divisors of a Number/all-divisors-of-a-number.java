class Solution {
	public ArrayList<Integer> getDivisors(int n) {
		// code here
		HashSet<Integer> ans = new HashSet<>();
		ArrayList<Integer> aa = new ArrayList<>();
		if (isPrime(n)) {
			aa.add(1);
			aa.add(n);
			return aa;
		}
		
		for (int i = 1; i*i <= n; i++) {
			if (n%i == 0) {
				ans.add(i);
				ans.add(n/i);
			}
		}
		for(int it: ans){
		    aa.add(it);
		}
		Collections.sort(aa);
		return aa;
	}
	public boolean isPrime(int n) {
		if (n<2) {
			return false;
		}
		if (n%2 == 0) {
			if (n == 2) {
				return true;
			}
			return false;
		}
		for (int i = 3; i*i <= n; i++) {
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}
}

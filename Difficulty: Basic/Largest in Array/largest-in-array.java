class Solution {
    public static int largest(int[] arr) {
        // code here
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.max(ans, arr[i]);
        }
        return ans;
    }
}
